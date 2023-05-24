package druginfo.service.read.repository;

import druginfo.service.read.model.Product;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Pageable;

@Repository
public interface ProductRepository
                extends ReactiveCrudRepository<Product, String>, ReactiveQueryByExampleExecutor<Product> {

        /**
         * Get all of the products by inputted name
         * 
         * @param productName
         * @return Flux<Product> - A list (flux) of products whose names match the input
         **/
        @Query("SELECT * FROM drugbank05_drugs_products u\n" +
                        "INNER JOIN drugbank05_drugs_general_info_full \n" +
                        "ON u.drugbank_id = drugbank05_drugs_general_info_full.drugbank_id\n" +
                        "WHERE lower(u.productname) LIKE lower('%' || :productName || '%') LIMIT 20;")
        Flux<Product> findByProductName(String productName);

        // @Query("SELECT p.productname FROM drugbank05_drugs_products dbp WHERE
        // p.productname LIKE CONCAT('%',:productname,'%')")
        // SELECT u FROM drugbank05_drugs_products u WHERE u.productname LIKE '%erb%'
        // select * from drugbank05_drugs_products where productname like $1

        /**
         * Get all of the drugs by inputted name
         * 
         * @param productID
         * @return Flux<Product> - A specific product whose ID matches the input
         **/
        @Query("SELECT drugbank05_drugs_products.product_id, drugbank05_drugs_products.drugbank_id, drugbank05_drugs_products.productname, drugbank05_drugs_products.productlabeller, drugbank05_drugs_products.productcode, drugbank05_drugs_products.productroute, drugbank05_drugs_products.productdosage, drugbank05_drugs_products.productstrength, drugbank05_drugs_products.approved, drugbank05_drugs_products.otc, drugbank05_drugs_products.generic, drugbank05_drugs_products.country, drugbank05_drugs_general_info_full.drugname, drugbank05_drugs_general_info_full.drugdescription, drugbank05_drugs_general_info_full.drugstate, drugbank05_drugs_general_info_full.drugindication, drugbank05_drugs_general_info_full.drugpharmaco, drugbank05_drugs_general_info_full.drugmechan, drugbank05_drugs_general_info_full.drugtoxicity, drugbank05_drugs_general_info_full.drugmetabo, drugbank05_drugs_general_info_full.drughalflife, drugbank05_drugs_general_info_full.drugelimination, drugbank05_drugs_general_info_full.drugclearance\n"
                        +
                        "FROM drugbank05_drugs_products\n" +
                        "INNER JOIN drugbank05_drugs_general_info_full\n" +
                        "ON drugbank05_drugs_products.drugbank_id = drugbank05_drugs_general_info_full.drugbank_id\n" +
                        "WHERE lower(drugbank05_drugs_products.product_id) LIKE lower(:productID)")
        Mono<Product> findProductByID(String productID);

        /**
         * Get all of the products by inputted product labeller
         * 
         * @param labeller
         * @return Flux<Product> - A list (flux) of drugs whose names match the input
         **/
        @Query("SELECT * FROM drugbank05_drugs_products u WHERE u.productlabeller LIKE :labeller||'%' LIMIT 20;")
        Flux<Product> findByProductLabeller(String labeller);

        /**
         * Get all of the products by inputted code
         * 
         * @param code
         * @return Flux<Product> - A list (flux) of drugs whose names match the input
         **/
        @Query("SELECT * FROM drugbank05_drugs_products u WHERE u.productcode LIKE :code||'%'")
        Flux<Product> findByProductCode(String code);

        /**
         * Get all of the products by inputted code
         * 
         * @return Flux<Product> - A list (flux) of drugs whose names match the input
         **/
        @Query("SELECT * FROM drugbank05_drugs_products LIMIT :limit")
        Flux<Product> findAll(int limit);

        @Query("SELECT * FROM drugbank05_drugs_products where lower(drugbank_id) LIKE lower('%' || :drugID || '%') LIMIT 20;")
        Flux<Product> suggestProducts(String drugID);
}
