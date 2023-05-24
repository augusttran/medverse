package druginfo.service.read.controller;

import druginfo.service.read.model.Drug;
import druginfo.service.read.model.Product;
import druginfo.service.read.repository.DrugRepository;
import druginfo.service.read.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

@RestController
@RequestMapping("/api/drugs")
public class DrugController {
    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private DrugService drugService;

    WebClient webClient = WebClient.builder().baseUrl("http://medverse.ddns.net/")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json").build();

    @GetMapping
    @Cacheable("drugs")
    public Flux<Drug> getDrugs() {

        return this.drugRepository.findAll();
    }

    @GetMapping("/t")
    public Mono<String> test() {
        return Mono.just("API Drugs works");
    }

    @GetMapping("/id")
    @Cacheable(value = "drug", key = " 'drugID' ")
    public Mono<ResponseEntity<Drug>> getDrugById(@RequestParam String drugID) {
        return this.drugRepository.findById(drugID)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/productId")
    @Cacheable(value = "drug", key = " 'productId' ")
    public Mono<ResponseEntity<Drug>> getDrugByProductId(@RequestParam String productId) {
        return this.drugRepository.findDrugByProductID(productId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/compare")
    @Cacheable(value = "compare", key = " 'productId1" +
            "" +
            "" +
            "" +
            "' ")
    public Flux<Drug> getDrugsByProductIDs(@RequestParam String productId1, @RequestParam String productId2) {
        return this.drugRepository.findDrugsByProductIDs(productId1, productId2);
    }

}
