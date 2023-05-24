package druginfo.service.metrics.controller;

import druginfo.service.metrics.models.SearchObject;
//import druginfo.service.metrics.repository.PgStatisticRepository;
import druginfo.service.metrics.repository.PgStatisticRepository;
import druginfo.service.metrics.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trafficcollector")
public class SearchTrafficController {

    @Autowired
    private PgStatisticRepository dbStatisticRepository;

    @Autowired
    private TrafficService trafficService;

    @GetMapping("/t")
    public String test() {
        return "API Metrics works!";
    }

    @RequestMapping(value = "/send", method = { RequestMethod.POST })
    public String writeSearchRequest(String productName) {
        SearchObject searchObject1 = new SearchObject(productName);
        System.out.println(searchObject1.getTimestamp());
        System.out.println(searchObject1.getRequest_id());
        System.out.println(searchObject1.getItem_id());
        System.out.println(searchObject1.getItem_name());
        this.trafficService.sendRequest(searchObject1);
        return "Ok";
    }

}
