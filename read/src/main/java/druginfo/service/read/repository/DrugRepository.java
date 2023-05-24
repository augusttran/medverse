package druginfo.service.read.repository;

import druginfo.service.read.model.Drug;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface DrugRepository extends ReactiveCrudRepository<Drug, String>, ReactiveQueryByExampleExecutor<Drug> {

        /**
         * Get all of the drugs by inputted name
         * 
         * @param drugName
         * @return Flux<Drug> - A list (flux) of drugs whose names match the input
         **/
        @Query(value = "SELECT * from drugbank05_drugs_general_info_full where drugname = :drugName")
        Flux<Drug> findByDrugName(String drugName);

        /**
         * Get all of the drugs by inputted name
         * 
         * @param productId
         * @return Flux<Drug> - A list (flux) of drugs whose names match the input
         **/
        @Query(value = "SELECT * from drugbank05_drugs_general_info_full inner join drugbank05_drugs_products\n" +
                        "on drugbank05_drugs_general_info_full.drugbank_id = drugbank05_drugs_products.drugbank_id\n" +
                        "where drugbank05_drugs_products.product_id = :productId;")
        Mono<Drug> findDrugByProductID(String productId);

        @Query(value = "SELECT * from drugbank05_drugs_general_info_full inner join drugbank05_drugs_products\n" +
                        "on drugbank05_drugs_general_info_full.drugbank_id = drugbank05_drugs_products.drugbank_id\n" +
                        "where drugbank05_drugs_products.product_id = :productId1 \n" +
                        "UNION ALL \n" +
                        "SELECT * from drugbank05_drugs_general_info_full inner join drugbank05_drugs_products\n" +
                        "on drugbank05_drugs_general_info_full.drugbank_id = drugbank05_drugs_products.drugbank_id\n" +
                        "where drugbank05_drugs_products.product_id = :productId2 ;")
        Flux<Drug> findDrugsByProductIDs(String productId1, String productId2);

        /**
         * Get a specific drug by its ID
         * 
         * @param drugbank_ID
         * @return Mono<Drug> - A single (mono) drug whose ID match the input
         **/
        @Query(value = "SELECT * FROM drugbank05_drugs_general_info_full where drugbank_id = :drugbank_ID")
        Mono<Drug> findDrugByID(@Param("drugbank_id") String drugbank_ID);

        /**
         * Get all drugs whose indications match with the input
         * 
         * @param indication
         * @return Flux<Drug> - A list (flux) of drugs whose indications match the input
         **/
        @Query(value = "SELECT * FROM drugbank05_drugs_general_info_full where drugindication = :indication")
        Flux<Drug> findByDrugIndication(@Param("drugindication") String indication);

        /**
         * Get all drugs whose pharmacodynamic characteristics match with the input
         * 
         * @param pharmaco
         * @return Flux<Drug> - A list (flux) of drugs whose pharmacokinetic match the
         *         input
         **/
        @Query(value = "SELECT * FROM drugbank05_drugs_general_info_full where drugpharmaco = :pharmaco")
        Flux<Drug> findbyDrugPharmacodynamicism(@Param("drugpharmaco") String pharmaco);

        /**
         * Get all drugs whose mechanisms characteristics match with the input
         * 
         * @param mechan
         * @return Flux<Drug> - A list (flux) of drugs whose mechanisms match the input
         **/
        @Query(value = "SELECT * FROM drugbank05_drugs_general_info_full where drugmechan = :mechan")
        Flux<Drug> findByDrugMechanism(@Param("drugmechan") String mechan);

        /**
         * Get all drugs whose metabolism characteristics match with the input
         * 
         * @param metabo
         * @return Flux<Drug> - A list (flux) of drugs whose metabolism match the input
         **/
        @Query(value = "SELECT * FROM drugbank05_drugs_general_info_full where drugmetabo = :metabo")
        Flux<Drug> findByDrugMetabolism(@Param("drugmetabo") String metabo);

        /**
         * Get all drugs whose toxicity characteristics match with the input
         * 
         * @param toxicity
         * @return Flux<Drug> - A list (flux) of drugs whose toxicity match the input
         **/
        @Query(value = "SELECT * FROM drugbank05_drugs_general_info_full where drugtoxicity = :toxicity")
        Flux<Drug> findByDrugToxicity(@Param("drugtoxicity") String toxicity);

        /**
         * Get all drugs whose halflife characteristics match with the input
         * 
         * @param halflife
         * @return Flux<Drug> - A list (flux) of drugs whose halflife time match the
         *         input
         **/
        @Query(value = "SELECT * FROM drugbank05_drugs_general_info_full where drughalflife = :halflife")
        Flux<Drug> findByDrugHalflife(@Param("drughalflife") String halflife);

        /**
         * Get all drugs whose elimination characteristics match with the input
         * 
         * @param elimination
         * @return Flux<Drug> - A list (flux) of drugs whose elimination match the input
         **/
        @Query(value = "SELECT * FROM drugbank05_drugs_general_info_full where drugelimination = :elimination")
        Flux<Drug> findByDrugElimination(@Param("drugelimination") String elimination);

        /**
         * Get all drugs whose clearance characteristics match with the input
         * 
         * @param clearance
         * @return Flux<Drug> - A list (flux) of drugs whose clearance match the input
         **/
        @Query(value = "SELECT * FROM drugbank05_drugs_general_info_full where drugclearance = :clearance")
        Flux<Drug> findByDrugClearance(@Param("drugclearance") String clearance);
}
