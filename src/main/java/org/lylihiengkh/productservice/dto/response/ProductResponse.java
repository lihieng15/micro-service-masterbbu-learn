package org.lylihiengkh.productservice.dto.response;

import lombok.*;

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
}
