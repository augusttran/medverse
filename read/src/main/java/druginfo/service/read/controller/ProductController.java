package druginfo.service.read.controller;

import druginfo.service.read.exception.ExceptionResponse;
import druginfo.service.read.model.Product;
import druginfo.service.read.repository.DrugRepository;
import druginfo.service.read.repository.ProductRepository;
//import druginfo.service.read.service.ProductService;
import druginfo.service.read.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.metrics.annotation.Timed;
import org.springframework.metrics.export.prometheus.EnablePrometheusMetrics;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.util.Comparator.comparing;

@RestController
@RequestMapping("/api/products")
@EnablePrometheusMetrics
public class ProductController {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    private static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private ProductService productService;

    @GetMapping("/t")
    public String test() {

        return "API Products works";
    }

    @Timed
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Product> getAllProducts(@RequestParam(value = "size", defaultValue = "10") int size) {
        Flux<Product> allProducts = this.productRepository.findAll(size)
                .sort(comparing(Product::getProductID));
        return allProducts;
    }

    @Timed
    @RequestMapping(value = "/id", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Product>> findProductByID(@RequestParam String productId) {
        Mono<Product> productInMono = this.productRepository.findProductByID(productId);

        if (productInMono == null) {
            throw new ExceptionResponse(now, "id-" + productId,
                    "Product not found when searching for this ID: " + productId);
        } else {
            return productInMono.map(ResponseEntity::ok)
                    .defaultIfEmpty(ResponseEntity.notFound().build());
        }
    }

    @Timed
    @RequestMapping(value = "/name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Product> getAllProductsByName(@RequestParam String name) {
        return this.productRepository.findByProductName(name);
    }

    @Timed
    @RequestMapping(value = "/code", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Product> findByProductCode(@RequestParam String code) {
        return this.productRepository.findByProductCode(code);
    }

    @Timed
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Product> updateProduct(@PathVariable String productID, @RequestBody Mono<Product> productMono) {
        return this.productService.updateProduct(productID, productMono);
    }

    @Timed
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Void> deleteProduct(@PathVariable String productID) {
        return this.productService.deleteSpecificProduct(productID);
    }

    @Timed
    @RequestMapping(value = "/suggest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Product> suggestSameDrugProducts(@RequestParam String id) {
        return this.productService.suggestProductsByDrugID(id);
    }
}
