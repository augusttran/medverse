package druginfo.service.metrics.service;

import druginfo.service.metrics.models.AddProductModel;
import druginfo.service.metrics.models.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllArticles();

    Product getArticleById(String productId);

    boolean addArticle(Product product);

    void updateArticle(Product product);

    void deleteArticle(String productId);

    List<Product> findAllProducts(int pageIndex, int pageSize);

    String addProductGeneralInfo(AddProductModel productModel);

    String addProduct(AddProductModel productModel);

    boolean editProductGeneralInfo(AddProductModel productModel);

    boolean editProduct(AddProductModel productModel);

    Iterable<Product> findAllProducts2();
}
