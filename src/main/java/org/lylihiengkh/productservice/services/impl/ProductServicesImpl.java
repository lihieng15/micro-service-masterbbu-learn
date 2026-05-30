package org.lylihiengkh.productservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.lylihiengkh.productservice.dto.request.ProductRequest;
import org.lylihiengkh.productservice.dto.response.ProductResponse;
import org.lylihiengkh.productservice.entities.ProductEntity;
import org.lylihiengkh.productservice.exceptions.ApiException;
import org.lylihiengkh.productservice.mappers.ProductMapper;
import org.lylihiengkh.productservice.repositories.CategoryRepository;
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
    private final CategoryRepository categoryRepository;

    public List<ProductResponse> getAllProducts() {
//        List<ProductResponse> list = new ArrayList<>();
        List<ProductEntity> productEntityList = productRepository.findAll();
//        productEntityList.forEach((data)->{
//            ProductResponse productResponse = productMapper.toResponse(data);
//            list.add(productResponse);
//        });
        return mapProductToResponseList(productEntityList);
    }

    @Override
    public ProductResponse getProductById(int id) {
        ProductEntity entity = productRepository.findById(id).orElse(null);
        if(entity == null){
            throw new ApiException("400","Product not found");
        }
        return productMapper.toResponse(entity);
    }

    @Override
    public void createProduct(ProductRequest req) {
        var entity = productMapper.toEntity(req);
        entity.setCategory(
                categoryRepository.findById(req.getCategoryId()).orElse(null)
        );
        productRepository.save(entity);
    }

    @Override
    public void update(ProductRequest req) {
        ProductEntity findProduct = productRepository.findById(req.getId()).orElse(null);
        if(findProduct == null){
            throw new RuntimeException("Product not found");
        }
        findProduct.setPrice(req.getPrice());
        findProduct.setDiscount(req.getDiscount());
        findProduct.setTitle(req.getTitle());
        findProduct.setDescription(req.getDescription());
        productRepository.save(findProduct);
    }

    @Override
    public void delete(int id, ProductRequest req){
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponse> getAllProductsByCategoryId(int id) {
        return mapProductToResponseList(productRepository.findAllByCategory_IdOrderByIdDesc(id));
    }



    private List<ProductResponse> mapProductToResponseList(List<ProductEntity> list){
        List<ProductResponse> responseList = new ArrayList<>();
        list.forEach((data)->{
            ProductResponse productResponse = productMapper.toResponse(data);
            responseList.add(productResponse);
        });
        return responseList;
    }



}
