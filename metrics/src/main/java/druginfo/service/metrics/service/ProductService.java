package druginfo.service.metrics.service;

import druginfo.service.metrics.models.AddProductModel;
import druginfo.service.metrics.models.Product;
import druginfo.service.metrics.models.ProductGeneralInfo;
import druginfo.service.metrics.repository.MedicinesGeneralInfoRepository;
import druginfo.service.metrics.repository.MedicinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class ProductService implements IProductService {

    @Autowired
    private MedicinesRepository medicinesRepository;

    @Autowired
    private MedicinesGeneralInfoRepository medicinesGeneralInfoRepository;

    ProductService(MedicinesRepository medicinesRepository) {
        this.medicinesRepository = medicinesRepository;
    }

    @Override
    public List<Product> getAllArticles() {
        List<Product> list = new ArrayList<>();
        medicinesRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Product getArticleById(String productId) {
        Product obj = medicinesRepository.findById(productId).get();
        return obj;
    }

    @Override
    public boolean addArticle(Product product) {
        return false;
    }

    @Override
    public void updateArticle(Product product) {
        medicinesRepository.save(product);
    }

    @Override
    public void deleteArticle(String productId) {
        medicinesRepository.delete(getArticleById(productId));
    }

    @Override
    public List<Product> findAllProducts(int pageIndex, int pageSize) {
        Pageable paginationRequest = PageRequest.of(pageIndex - 1, pageSize);
        return medicinesRepository.findAll(paginationRequest).getContent();
    }

    @Override
    public String addProductGeneralInfo(AddProductModel productModel) {
        String lastInfoId = medicinesGeneralInfoRepository.getLastItemId();
        int numberPartitionOfLastInfoId = Integer.parseInt(lastInfoId.substring(2));
        String newItemId = "DB" + (numberPartitionOfLastInfoId + 1);

        ProductGeneralInfo info = new ProductGeneralInfo();
        info.setId(newItemId);
        info.setDrugName(productModel.getDrugName());
        info.setDrugDescription(productModel.getDrugDescription());
        info.setDrugState(productModel.getDrugState());
        info.setDrugIndication(productModel.getDrugIndication());
        info.setDrugPharmaco(productModel.getDrugPharmaco());
        info.setDrugMechan(productModel.getDrugMechan());
        info.setDrugToxicity(productModel.getDrugToxicity());
        info.setDrugMetabo(productModel.getDrugMetabo());
        info.setDrugHalflife(productModel.getDrugHalflife());
        info.setDrugLimination(productModel.getDrugElimination());
        info.setDrugClearance(productModel.getDrugClearance());
        medicinesGeneralInfoRepository.save(info);
        return newItemId;
    }

    @Override
    public String addProduct(AddProductModel productModel) {
        String lastProductId = medicinesRepository.getLastItemId();
        int numberPartitionOfLastInfoId = Integer.parseInt(lastProductId.substring(3));
        String newItemId = "PID" + (numberPartitionOfLastInfoId + 1);

        Product product = new Product();
        product.setProductID(newItemId);
        product.setDrugbankID(productModel.getDrugBankId());
        product.setProductName(productModel.getDrugName());
        product.setProductLabeller(productModel.getProductLabeller());
        product.setProductdosage(productModel.getProductDosage());
        product.setProductCode(productModel.getProductCode());
        product.setProductStrength(productModel.getProductStrength());
        product.setGeneric(productModel.getGeneric());
        product.setOtc(productModel.getOtc());
        product.setApproved(productModel.getApproved());
        product.setProductRoute(productModel.getProductRoute());
        product.setCountry(productModel.getCountry());
        medicinesRepository.save(product);
        return newItemId;
    }

    @Override
    public boolean editProductGeneralInfo(AddProductModel productModel) {
        Optional<ProductGeneralInfo> optionalItem = medicinesGeneralInfoRepository
                .findById(productModel.getDrugBankId());
        if (optionalItem.isPresent()) {
            ProductGeneralInfo item = optionalItem.get();
            item.setDrugName(productModel.getDrugName());
            item.setDrugDescription(productModel.getDrugDescription());
            item.setDrugState(productModel.getDrugState());
            item.setDrugIndication(productModel.getDrugIndication());
            item.setDrugPharmaco(productModel.getDrugPharmaco());
            item.setDrugMechan(productModel.getDrugMechan());
            item.setDrugToxicity(productModel.getDrugToxicity());
            item.setDrugMetabo(productModel.getDrugMetabo());
            item.setDrugHalflife(productModel.getDrugHalflife());
            item.setDrugLimination(productModel.getDrugElimination());
            item.setDrugClearance(productModel.getDrugClearance());
            medicinesGeneralInfoRepository.save(item);
            return true;
        }
        return false;
    }

    @Override
    public boolean editProduct(AddProductModel productModel) {
        Optional<Product> optionalItem = medicinesRepository.findById(productModel.getProductId());
        if (optionalItem.isPresent()) {
            Product item = optionalItem.get();
            item.setDrugbankID(productModel.getDrugBankId());
            item.setProductName(productModel.getDrugName());
            item.setProductLabeller(productModel.getProductLabeller());
            item.setProductdosage(productModel.getProductDosage());
            item.setProductCode(productModel.getProductCode());
            item.setProductStrength(productModel.getProductStrength());
            item.setGeneric(productModel.getGeneric());
            item.setOtc(productModel.getOtc());
            item.setApproved(productModel.getApproved());
            item.setProductRoute(productModel.getProductRoute());
            item.setCountry(productModel.getCountry());
            medicinesRepository.save(item);
            return true;
        }
        return false;
    }

    @Override
    public Iterable<Product> findAllProducts2() {
        return medicinesRepository.findAll();
    }
}
