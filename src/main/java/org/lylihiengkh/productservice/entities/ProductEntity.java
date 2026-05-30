package org.lylihiengkh.productservice.entities;

import jakarta.persistence.*;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private Double price;
    private Double discount;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    private boolean deleted;
    @ManyToOne
    private CategoryEntity category;

}
