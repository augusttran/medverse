package druginfo.service.read.service;

import druginfo.service.read.model.Product;
import druginfo.service.read.model.TrendPillData;
import druginfo.service.read.repository.ProductRepository;
import druginfo.service.read.repository.TrendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class TrendPillDataService {
    //
    @Autowired
    private TrendRepository trendRepository;

    /**
     * Get all of the drugs by inputted name
     * 
     * @param trendID
     * @return Flux<Product> - A list (flux) of drugs whose names match the input
     * @throws Exception
     **/
    public Flux<TrendPillData> searchByTrendID(String trendID) throws Exception {
        return trendRepository.findByTrendID(trendID);
    }
}
