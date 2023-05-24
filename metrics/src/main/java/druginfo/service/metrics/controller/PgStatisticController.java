package druginfo.service.metrics.controller;

import druginfo.service.metrics.models.CountModel;
import druginfo.service.metrics.models.PgStatisticResult;
import druginfo.service.metrics.models.QueryCountModel;
import druginfo.service.metrics.repository.PgStatisticRepository;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
public class PgStatisticController {

    @Autowired
    private PgStatisticRepository dbStatisticRepository;

    /*
     * This piece of code is implemented to query statistics of all tables.
     *
     */
    // @Cacheable("tablestats")
    @Timed
    @RequestMapping(value = "/tablestats", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PgStatisticResult> collectAllStatistic() {
        return this.dbStatisticRepository.findAll();
    }

    /*
     * This piece of code is implemented to query statistics of all tables' row
     * counts.
     *
     */
    // @Cacheable("totalproductsbytype")
    @Timed
    @RequestMapping(value = "/totalproductbytypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QueryCountModel> countOtcProducts() {
        return this.dbStatisticRepository.getOtcApprovedGenericCount();
    }

    /*
     * This piece of code is implemented to query statistics of all tables' row
     * counts.
     *
     */
    // @Cacheable("totalrowsbycountry")
    @Timed
    @RequestMapping(value = "/totalrowsbycountry", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QueryCountModel> countProductByCountries() {
        return this.dbStatisticRepository.getProductsTypeCountByCountry();
    }

    /*
     * This piece of code is implemented to query statistics of all tables' row
     * counts.
     *
     */
    // @Cacheable("totalrows")
    @Timed
    @RequestMapping(value = "/totalrows", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CountModel> allTableRows() {
        return this.dbStatisticRepository.getTotalRowsAllTable();
    }

}
