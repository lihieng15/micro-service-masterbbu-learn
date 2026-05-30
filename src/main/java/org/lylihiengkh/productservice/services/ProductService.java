package org.lylihiengkh.productservice.services;

import org.lylihiengkh.productservice.dto.request.ProductRequest;
import org.lylihiengkh.productservice.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(int id);
    void createProduct(ProductRequest req);
    void update(ProductRequest req);
    void delete(int id, ProductRequest req);
    List<ProductResponse> getAllProductsByCategoryId(int categoryId);
}
