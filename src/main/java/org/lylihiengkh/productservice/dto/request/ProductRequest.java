package org.lylihiengkh.productservice.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private int id;
    private String title;
    private String description;
    private Double price;
    private Double discount;
    private int categoryId;
}
