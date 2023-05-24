package druginfo.service.read.repository;

import druginfo.service.read.model.PillData;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PillDataRepository
        extends ReactiveCrudRepository<PillData, String>, ReactiveQueryByExampleExecutor<PillData> {

    /**
     * Get pill data by pill Info
     * 
     * @param pillInfo
     * @return Mono<PillData> - A single pill data whose pill data matches inputted
     *         pill data.
     **/
    @Query("SELECT * FROM drugbank05_pill_images_detail_data p WHERE p.pill_info LIKE '%pillInfo%';")
    Flux<PillData> findPillByPillInfo(String pillInfo);

    /**
     * Get pill data by pill shape
     * 
     * @param pillShape
     * @return Mono<PillData> - A single pill data whose pill data matches inputted
     *         pill data.
     **/
    @Query("SELECT * FROM drugbank05_pill_images_detail_data p WHERE p.pill_shape like ('%' || :pillShape || '%');")
    Flux<PillData> findPillByPillShape(String pillShape);

    /**
     * Get pill data by pill size
     * 
     * @param pillSize
     * @return Mono<PillData> - A single pill data whose pill data matches inputted
     *         pill data.
     **/
    @Query("SELECT * FROM drugbank05_pill_images_detail_data p WHERE p.pill_size like ('%' || :pillSize || '%');")
    Flux<PillData> findPillByPillSize(String pillSize);

    /**
     * Get pill data by pill colors
     * 
     * @param pillColors
     * @return Mono<PillData> - A single pill data whose pill data matches inputted
     *         pill data.
     **/
    @Query("SELECT * FROM drugbank05_pill_images_detail_data p WHERE lower(p.pill_colors) like lower('%' || :pillColors || '%');")
    Flux<PillData> findPillByPillColors(String pillColors);

    /**
     * Get pill data by pill Imprints
     * 
     * @param pillImprints
     * @return Mono<PillData> - A single pill data whose pill data matches inputted
     *         pill data.
     **/
    @Query("SELECT * FROM drugbank05_pill_images_detail_data p WHERE lower(p.pill_imprints) like lower('%' ||  :pillImprints || '%');")
    Flux<PillData> findPillByPillImprints(String pillImprints);

    /**
     * Get pill data by pill Imprints
     * 
     * @param pillImprints
     * @return Mono<PillData> - A single pill data whose pill data matches inputted
     *         pill data.
     **/
    @Query("SELECT * FROM drugbank05_pill_images_detail_data p WHERE lower(p.pill_imprints) like lower('%' ||  :pillImprints || '%');")
    Flux<PillData> findPillByPillImprintsAndShape(String pillImprints);

    /**
     * Composite endpoints
     * Get pill data by pill Imprints
     * 
     * @param pillOverview
     * @param pillImprints
     * @return Mono<PillData> - A single pill data whose pill data matches inputted
     *         pill data.
     **/
    @Query("SELECT * FROM drugbank05_pill_images_detail_data p WHERE lower(p.pillOverview) like lower('%' ||  :pillOverview || '%') and lower(p.pill_imprints) like lower('%' ||  :pillImprints || '%');")
    Flux<PillData> findPillByPillImprintsAndShape(String pillOverview, String pillImprints);

}
