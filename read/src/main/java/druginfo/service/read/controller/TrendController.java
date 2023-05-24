package druginfo.service.read.controller;

import druginfo.service.read.model.PillData;
import druginfo.service.read.model.Product;
import druginfo.service.read.model.TrendPillData;
import druginfo.service.read.repository.TrendRepository;
import druginfo.service.read.service.DrugService;
import druginfo.service.read.service.TrendPillDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.metrics.annotation.Timed;
import org.springframework.metrics.export.prometheus.EnablePrometheusMetrics;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/trends")
@EnablePrometheusMetrics
public class TrendController {

    @Autowired
    private TrendPillDataService trendPillDataService;

    @Autowired
    private TrendRepository trendRepository;

    @GetMapping("/t")
    public String test() {

        return "API Trends works";
    }

    @Timed
    @RequestMapping(value = "/id", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<TrendPillData> suggestSameDrugProducts(@RequestParam String trendId) throws Exception {
        return this.trendRepository.findByTrendID(trendId);
    }

}
