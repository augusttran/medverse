package druginfo.service.metrics.repository;

import druginfo.service.metrics.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MedicinesRepository extends PagingAndSortingRepository<Product, String> {
    @Query(value = "SELECT product_id FROM drugbank05_drugs_products ORDER BY product_id DESC LIMIT 1", nativeQuery = true)
    String getLastItemId();
}
