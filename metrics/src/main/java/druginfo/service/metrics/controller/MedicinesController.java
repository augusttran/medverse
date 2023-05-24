package druginfo.service.metrics.controller;

import druginfo.service.metrics.models.AddProductModel;
import druginfo.service.metrics.models.Product;
import druginfo.service.metrics.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/medicines")
@CrossOrigin
public class MedicinesController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public Iterable<Product> getAllProducts(
            @RequestParam(defaultValue = "1") int pageIndex,
            @RequestParam(defaultValue = "10") int pageSize) {
        if (pageIndex <= 0 || pageSize <= 0)
            return new ArrayList<>();
        return productService.findAllProducts(pageIndex, pageSize);
    }

    @PostMapping("product-general")
    public String addProductGeneralInfo(@ModelAttribute AddProductModel model) {
        return productService.addProductGeneralInfo(model);
    }

    @PostMapping("product")
    public String addProduct(@ModelAttribute AddProductModel model) {
        return productService.addProduct(model);
    }

    @PutMapping("product-general")
    public String editProductGeneralInfo(@ModelAttribute AddProductModel model) {
        boolean isSuccess = productService.editProductGeneralInfo(model);
        return String.valueOf(isSuccess);
    }

    @PutMapping("product")
    public String editProduct(@ModelAttribute AddProductModel model) {
        boolean isSuccess = productService.editProduct(model);
        return String.valueOf(isSuccess);
    }
}