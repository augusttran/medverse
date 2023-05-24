package druginfo.service.read.controller;

import druginfo.service.read.model.Photo;
import druginfo.service.read.model.Product;
import druginfo.service.read.repository.PhotosRepository;
import druginfo.service.read.repository.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.metrics.annotation.Timed;
import org.springframework.metrics.export.prometheus.EnablePrometheusMetrics;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/photos")
@EnablePrometheusMetrics
public class PhotoController {
    @Autowired
    private PhotosRepository photosRepository;

    @Cacheable
    @Timed
    @RequestMapping(value = "/rxName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Flux<Photo> findProductByID(@RequestParam String rxName) {
        return this.photosRepository.findPhotosByRxName(rxName);
//                .map(ResponseEntity::ok)
//                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Cacheable
    @Timed
    @RequestMapping(value = "/ndc11", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Flux<Photo> findPhotoByNdc11(String ndc11) {
        return this.photosRepository.findPhotosByNDC11(ndc11);
//                .map(ResponseEntity::ok)
//                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Cacheable
    @Timed
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Flux<Photo> findAllPhotos() {
        return this.photosRepository.findAllPhotos();
//                .map(ResponseEntity::ok)
//                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}

