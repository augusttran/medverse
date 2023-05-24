package druginfo.service.read.service;

import druginfo.service.read.model.Drug;
import druginfo.service.read.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DrugService {
    @Autowired
    private DrugRepository drugRepository;

    /**
     * Get all of the drugs by inputted name
     * 
     * @param name
     * @return Flux<Drug> - A list (flux) of drugs whose names match the input
     * @throws Exception
     **/
    public Flux<Drug> searchesAllDrugsByName(String name) throws Exception {
        return drugRepository.findByDrugName(name);
    }

    /**
     * Get all of the drugs by inputted name
     * 
     * @param drugID
     * @return Mono<Drug> - A list (flux) of drugs whose names match the input
     * @throws Exception
     **/
    public Mono<Drug> searchByDrugbankID(String drugID) throws Exception {
        return drugRepository.findDrugByID(drugID);
    }

    /**
     * Get all of the drugs by inputted name
     * 
     * @param drugIndication
     * @return Flux<Drug> - A list (flux) of drugs whose indications match the input
     * @throws Exception
     **/
    public Flux<Drug> searchByDrugIndication(String drugIndication) throws Exception {
        return drugRepository.findByDrugIndication(drugIndication);
    }

    /**
     * Get all of the drugs by inputted name
     * 
     * @param pharmaco
     * @return Flux<Drug> - A list (flux) of drugs whose indications match the input
     * @throws Exception
     **/
    public Flux<Drug> searchByDrugPharmaco(String pharmaco) throws Exception {
        return drugRepository.findbyDrugPharmacodynamicism(pharmaco);
    }

    /**
     * Get all of the drugs by inputted name
     * 
     * @param mechan
     * @return Flux<Drug> - A list (flux) of drugs whose indications match the input
     * @throws Exception
     **/
    public Flux<Drug> searchByDrugMechanism(String mechan) throws Exception {
        return drugRepository.findByDrugMechanism(mechan);
    }

    /**
     * Get all of the drugs by inputted name
     * 
     * @param metabol
     * @return Flux<Drug> - A list (flux) of drugs whose indications match the input
     * @throws Exception
     **/
    public Flux<Drug> searchByDrugMetabolism(String metabol) throws Exception {
        return drugRepository.findByDrugMetabolism(metabol);
    }
}
