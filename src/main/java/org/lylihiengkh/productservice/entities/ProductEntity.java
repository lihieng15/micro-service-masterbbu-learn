package org.lylihiengkh.productservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//when connect to database
@Entity
@Table(name = "products")
public class ProductEntity {
    //@id mean id is primary key
    @Id
    private int id;
    private String title;
    private String description;
    private Double price;
    private Double discount;
    private LocalDateTime createdDate;
    private boolean deleted;

}
