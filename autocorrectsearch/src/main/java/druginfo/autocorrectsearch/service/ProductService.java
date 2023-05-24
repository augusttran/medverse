package druginfo.autocorrectsearch.service;

import druginfo.autocorrectsearch.model.Product;
import druginfo.autocorrectsearch.repository.ProductRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findById(final String id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> findByContainingName(final String name, Integer pageSize) {
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10; // default
        }
        return productRepository.findAllByName(name,
                PageRequest.of(0, pageSize)).stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toUnmodifiableList());
    }
}
