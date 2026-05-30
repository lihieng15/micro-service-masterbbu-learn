package org.lylihiengkh.productservice.mappers;

import org.lylihiengkh.productservice.dto.request.ProductRequest;
import org.lylihiengkh.productservice.dto.response.ProductResponse;
import org.lylihiengkh.productservice.entities.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductEntity toEntity(ProductRequest request) {
        return ProductEntity.builder()
                .id(request.getId())
                .title(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .discount(request.getDiscount())
                .build();
    }

    public ProductResponse toResponse(ProductEntity response) {
        return ProductResponse.builder()
                .id(response.getId())
                .title(response.getTitle())
                .description(response.getDescription())
                .price(response.getPrice())
                .discount(response.getDiscount())
                .build();
    }



}
