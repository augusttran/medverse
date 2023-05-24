package druginfo.service.read.repository;

import druginfo.service.read.model.TrendPillData;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TrendRepository
        extends ReactiveCrudRepository<TrendPillData, String>, R2dbcRepository<TrendPillData, String> {

    /**
     * Get all of the drugs by inputted name
     * 
     * @param trendId
     * @return Flux<TrendPillData> - A list (flux) of drugs whose names match the
     *         input
     **/
    @Query("select trend_pill_id, trend_id, pill_data_id, rxname, rxnavimagefilename from drugbank05_trends_pills inner join \n"
            +
            "drugbank05_pill_images_directory on drugbank05_trends_pills.pill_data_id = drugbank05_pill_images_directory.rxnavimageobjectid\n"
            +
            "where lower(drugbank05_trends_pills.trend_id) like lower('%' || :trendId || '%');")
    Flux<TrendPillData> findByTrendID(String trendId);

}
