package druginfo.service.read.service;

import druginfo.service.read.model.PillData;
import druginfo.service.read.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class PillService {

    @Autowired
    private DrugRepository drugRepository;

    public Flux<PillData> pillsByTrends(String trend) {

        if (trend.equals("summer")) {

        }
        return null;
    }
}
