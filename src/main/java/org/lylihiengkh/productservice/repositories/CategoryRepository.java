package org.lylihiengkh.productservice.repositories;

import org.lylihiengkh.productservice.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
    CategoryEntity findByName(String name);
}
