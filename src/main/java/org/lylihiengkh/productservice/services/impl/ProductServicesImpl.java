package org.lylihiengkh.productservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.lylihiengkh.productservice.dto.request.ProductRequest;
import org.lylihiengkh.productservice.dto.response.ProductResponse;
import org.lylihiengkh.productservice.entities.ProductEntity;
import org.lylihiengkh.productservice.mappers.ProductMapper;
import org.lylihiengkh.productservice.repositories.ProductRepository;
import org.lylihiengkh.productservice.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServicesImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> list = new ArrayList<>();
        List<ProductEntity> productEntitiesList = productRepository.findAll();
        productEntitiesList.forEach((data)->{
            ProductResponse productResponse = productMapper.toResponse(data);
            list.add(productResponse);
        });
        return list;
    }

    @Override
    public ProductResponse getProductById(int id) {
        ProductEntity entity = productRepository.findById(id).orElse(null);
        if(entity == null){
            throw new RuntimeException("Product not found");
        }
        return productMapper.toResponse(entity);
    }

    @Override
    public void createProduct(ProductRequest req) {
        productRepository.save(productMapper.toEntity(req));
    }

    @Override
    public void update(ProductRequest req) {
//        productRepository.update(productMapper.toEntity(req));
    }

    @Override
    public void delete(int id, ProductRequest req){
//        productRepository.delete(id);
    }
}
