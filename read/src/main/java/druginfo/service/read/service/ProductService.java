package druginfo.service.read.service;

import druginfo.service.read.model.Product;
import druginfo.service.read.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Get all of the drugs by inputted name
     * 
     * @param limit
     * @return Flux<Product> - A list (flux) of drugs whose names match the input
     * @throws Exception
     **/
    public Flux<Product> getAllProductsWithLimit(int limit) throws Exception {
        return productRepository.findAll(limit);
    }

    /**
     * Get all of the drugs by inputted name
     * 
     * @param name
     * @return Flux<Product> - A list (flux) of drugs whose names match the input
     * @throws Exception
     **/
    public Flux<Product> searchByProductName(String name) throws Exception {
        return productRepository.findByProductName(name);
    }

    /**
     * Get all of the drugs by inputted name
     * 
     * @param id
     * @return Flux<Product> - A list (flux) of drugs whose names match the input
     * @throws Exception
     **/
    public Mono<Product> searchByProductID(String id) throws Exception {
        return productRepository.findProductByID(id);
    }

    /**
     * Get all of the drugs by inputted name
     * 
     * @param labeller
     * @return Flux<Product> - A list (flux) of drugs whose names match the input
     * @throws Exception
     **/
    public Flux<Product> searchByProductLabeller(String labeller) throws Exception {
        return productRepository.findByProductLabeller(labeller);
    }

    public Mono<Product> updateProduct(String productID, final Mono<Product> productMono) {
        return this.productRepository.findProductByID(productID)
                .flatMap(p -> productMono.map(u -> {
                    p.setProductdosage(u.getProductdosage());
                    p.setProductRoute(u.getProductRoute());
                    p.setProductStrength(u.getProductStrength());
                    p.setCountry(u.getCountry());
                    p.setApproved(u.getApproved());
                    p.setOtc(u.getOtc());
                    p.setProductCode(u.getProductCode());
                    p.setProductName(u.getProductName());
                    p.setProductLabeller(u.getProductLabeller());
                    return p;
                }))
                .flatMap(p -> this.productRepository.save(p));
    }

    public Mono<Void> deleteSpecificProduct(final String id) {
        return this.productRepository.deleteById(id);
    }

    public Flux<Product> suggestProductsByDrugID(final String drugID) {
        return this.productRepository.suggestProducts(drugID);
    }

}
