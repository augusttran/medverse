package druginfo.service.read.repository;

import druginfo.service.read.model.Photo;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PhotosRepository extends ReactiveCrudRepository<Photo, String>, ReactiveQueryByExampleExecutor<Photo> {

    /**
     * Get all of the photos by inputted rxName
     * 
     * @param rxName
     * @return Flux<Photo> - A list (flux) of Photos whose names match the input
     **/
    // @Query("SELECT * FROM drugbank05_pill_images_directory u WHERE
    // lower(u.rxname) LIKE lower('%' || :rxName || '%') ")
    @Query("SELECT * FROM drugbank05_pill_images_directory u WHERE lower(u.rxname) LIKE lower(:rxName||'%')")
    Flux<Photo> findPhotosByRxName(String rxName);

    /**
     * Get all of the photos by inputted ndc11
     * 
     * @param ndc11Code
     * @return Flux<Photo> - A list (flux) of Photos whose names match the input
     **/
    @Query("SELECT * FROM drugbank05_pill_images_directory u WHERE lower(u.ndc11) LIKE lower('%' || :ndc11Code || '%')  ")
    Flux<Photo> findPhotosByNDC11(String ndc11Codse);

    /**
     * Get all of the photos by inputted ndc11
     * 
     * @param
     * @return Flux<Photo> - A list (flux) of Photos whose names match the input
     **/
    @Query("SELECT * FROM drugbank05_pill_images_directory")
    Flux<Photo> findAllPhotos();
}
