package druginfo.service.read.repository;

import druginfo.service.read.model.Interaction;
import druginfo.service.read.model.Product;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface InteractionRepository
        extends ReactiveCrudRepository<Interaction, String>, ReactiveQueryByExampleExecutor<Interaction> {

    /**
     * OK
     * Get interaction by two drugs ID
     * 
     * @param firstDrugId
     * @param secondDrugId
     * @return Mono<Interaction> - A single interaction whose ID matches two
     *         mentioned drug IDs.
     *         select * from drugbank05_drugs_interactions u where
     *         concat('DB00001','DB00006') = u.interaction_id;
     **/
    @Query("select * from drugbank05_drugs_interactions where concat_ws('', :firstDrugId, :secondDrugId) like interaction_id;")
    Mono<Interaction> findInteractionByDrugIDs(String firstDrugId, String secondDrugId);

    /**
     * Get all of the drugs by firstDrug's ID and secondDrug's name
     * 
     * @param firstDrugId
     * @param secondDrugName
     * @return Mono<Interaction> - A specific product whose ID matches the input
     **/
    @Query("SELECT * FROM drugbank05_drugs_interactions where drugbank_id_1 like :firstDrugId and lower(drug_2_name) LIKE lower('%' || :secondDrugName || '%')")
    Mono<Interaction> findInteractionByFirstDrugIDandSecondDrugNames(String firstDrugId, String secondDrugName);

    /**
     * Get all of the interactions by inputted drugbankId
     * 
     * @param drugbankId
     * @return Flux<Interaction> - A list (flux) of drugs whose names match the
     *         input
     **/
    @Query("SELECT * FROM drugbank05_drugs_interactions WHERE drugbank_id_1 = :drugbankId")
    Flux<Interaction> findAllInteractionsOfSpecificDrug(String drugbankId);

    /**
     * Get all of the products by inputted code
     * 
     * @param drugName
     * @param riskDescription
     * @return Flux<Product> - A list (flux) of drugs whose names match the input
     **/
    @Query("SELECT * FROM drugbank05_drugs_interactions i WHERE lower(i.drug_2_name) LIKE lower('%' || :drugName || '%') and lower(i.interaction_description) LIKE lower('%' || :riskDescription || '%')")
    Flux<Interaction> findInteractionByDrugIdAndDescription(String drugName, String riskDescription);
}
