package org.lylihiengkh.productservice.services.impl;

import lombok.AllArgsConstructor;
import org.lylihiengkh.productservice.dto.request.CategoryRequest;
import org.lylihiengkh.productservice.entities.CategoryEntity;
import org.lylihiengkh.productservice.repositories.CategoryRepository;
import org.lylihiengkh.productservice.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void createCategory(CategoryRequest reqCat) {
        CategoryEntity existName = categoryRepository.findByName(reqCat.getName());

        if(existName != null){
            throw new RuntimeException("Category already exist");

        }
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(reqCat.getName());
        categoryRepository.save(categoryEntity);

    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }
}
