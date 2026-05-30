package org.lylihiengkh.productservice.controllers;


import lombok.RequiredArgsConstructor;
import org.lylihiengkh.productservice.dto.request.CategoryRequest;
import org.lylihiengkh.productservice.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;


    @PostMapping
    public ResponseEntity<Object> createCategory(
            @RequestBody CategoryRequest request
    ){
        categoryService.createCategory(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Object> getAllCategory(){
        return new ResponseEntity<>(
                categoryService.getAllCategories(),
                HttpStatus.OK
        );
    }

}
