package druginfo.service.metrics.repository;

import druginfo.service.metrics.models.ProductGeneralInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MedicinesGeneralInfoRepository extends CrudRepository<ProductGeneralInfo, String> {
    @Query(value = "SELECT drugbank_id FROM drugbank05_drugs_general_info_full ORDER BY drugbank_id DESC LIMIT 1", nativeQuery = true)
    String getLastItemId();
}
