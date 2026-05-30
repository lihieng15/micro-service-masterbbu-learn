package org.lylihiengkh.productservice.repositories;

import org.lylihiengkh.productservice.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    List<ProductEntity> findAllByCategory_Id(int categoryId);
    List<ProductEntity> findAllByCategory_IdOrderByIdDesc(int categoryId);
}
