package org.lylihiengkh.productservice.dto.response;

import lombok.*;
import org.lylihiengkh.productservice.entities.CategoryEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProductResponse {
    private int id;
    private String title;
    private String description;
    private Double price;
    private Double discount;
    private String createdDate;// 12/02/2026
    private CategoryEntity category;
}
