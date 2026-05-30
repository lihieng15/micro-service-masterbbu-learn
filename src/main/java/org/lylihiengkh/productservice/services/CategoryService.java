package org.lylihiengkh.productservice.services;

import org.lylihiengkh.productservice.dto.request.CategoryRequest;
import org.lylihiengkh.productservice.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {
    void createCategory(CategoryRequest reqCat);
    List<CategoryEntity> getAllCategories();
}
