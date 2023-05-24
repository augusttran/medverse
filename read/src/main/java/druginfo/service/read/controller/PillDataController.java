package druginfo.service.read.controller;

import druginfo.service.read.model.PillData;
import druginfo.service.read.repository.PillDataRepository;
import druginfo.service.read.service.PillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.metrics.annotation.Timed;
import org.springframework.metrics.export.prometheus.EnablePrometheusMetrics;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/pills")
@EnablePrometheusMetrics
public class PillDataController {

    @Autowired
    public PillDataRepository pillDataRepository;

    @Autowired
    public PillService pillService;

    @Cacheable
    @Timed
    @RequestMapping(value = "/imprint", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Flux<PillData> findPillDataByImprints(@RequestParam String impr) {
        return this.pillDataRepository.findPillByPillImprints(impr);

    }

    @Cacheable
    @Timed
    @RequestMapping(value = "/size", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Flux<PillData> findPillBySize(String sz) {
        return this.pillDataRepository.findPillByPillSize(sz);
    }

    @Cacheable
    @Timed
    @RequestMapping(value = "/shape", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Flux<PillData> findPillByShape(String shp) {
        return this.pillDataRepository.findPillByPillShape(shp);
    }

    @Cacheable
    @Timed
    @RequestMapping(value = "/colors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Flux<PillData> find(String colors) {
        return this.pillDataRepository.findPillByPillColors(colors);
    }

    @Cacheable
    @Timed
    @RequestMapping(value = "/info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Flux<PillData> findByInfo(String info) {
        return this.pillDataRepository.findPillByPillInfo(info);
    }

    @Cacheable("trends")
    @Timed
    @RequestMapping(value = "/trends", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Flux<PillData> trendPills(@RequestParam String trendName) {
        return this.pillService.pillsByTrends(trendName);
    }
}
