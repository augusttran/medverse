package druginfo.service.metrics.repository;

import druginfo.service.metrics.models.SearchObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface TrafficRepository extends PagingAndSortingRepository<SearchObject, String> {

}
