package druginfo.service.metrics.service;

import druginfo.service.metrics.models.SearchObject;
//import druginfo.service.metrics.repository.TrafficRepository;
import druginfo.service.metrics.repository.TrafficRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Component
public class TrafficService {

    @Autowired
    private TrafficRepository trafficRepository;

    public boolean sendRequest(SearchObject searchObject) {
        boolean result = false;

        this.trafficRepository.save(searchObject);
        return result;
    }

}
