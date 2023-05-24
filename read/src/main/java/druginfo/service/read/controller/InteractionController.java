package druginfo.service.read.controller;

import druginfo.service.read.model.Interaction;
import druginfo.service.read.repository.InteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.metrics.annotation.Timed;
import org.springframework.metrics.export.prometheus.EnablePrometheusMetrics;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/interactions")
@EnablePrometheusMetrics
public class InteractionController {
    @Autowired
    private InteractionRepository interactionRepository;

    @GetMapping("/t")
    public String test() {

        return "API Interaction works";
    }

    @Cacheable("interaction1")
    @Timed
    @RequestMapping(value = "/checkByTwoIDs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Mono<Interaction> findInteractionByTwoDrugIDs(@RequestParam String firstID, @RequestParam String secondID) {
        return this.interactionRepository.findInteractionByDrugIDs(firstID, secondID);

    }

    @Cacheable("interaction2")
    @Timed
    @RequestMapping(value = "/checkByIDandName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Mono<Interaction> findInteractionByTwoDrugNames(@RequestParam String firstName,
            @RequestParam String secondName) {
        return this.interactionRepository.findInteractionByFirstDrugIDandSecondDrugNames(firstName, secondName);

    }

    @Cacheable("interaction3")
    @Timed
    @RequestMapping(value = "/{drugID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Flux<Interaction> findAllInteractionsOfASpecificDrug(@PathVariable String drugID) {
        return this.interactionRepository.findAllInteractionsOfSpecificDrug(drugID);

    }

    @Cacheable("interaction4")
    @Timed
    @RequestMapping(value = "/checkByDrugNameAndInteractionDescription", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Flux<Interaction> findAllInteractionsOfASpecificDrug(@RequestParam String name, String des) {
        return this.interactionRepository.findInteractionByDrugIdAndDescription(name, des);

    }

}