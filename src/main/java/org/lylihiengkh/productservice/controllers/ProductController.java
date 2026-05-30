package org.lylihiengkh.productservice.controllers;

import lombok.RequiredArgsConstructor;
import org.lylihiengkh.productservice.dto.request.ProductRequest;
import org.lylihiengkh.productservice.dto.response.ProductResponse;
import org.lylihiengkh.productservice.exceptions.MessageResponse;
import org.lylihiengkh.productservice.services.ProductService;
import org.osgi.annotation.bundle.Headers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<MessageResponse<List<ProductResponse>>> getAllProducts(){
        return new ResponseEntity<>(
                new MessageResponse<>(
                        productService.getAllProducts(),
                        true,
                        "Get data products",
                        "200"
                ),
                HttpStatus.OK
        );
    }
    // /api/v1/products/1
    @GetMapping("/{product-id}")
    public ResponseEntity<MessageResponse<ProductResponse>> getProductById(@PathVariable("product-id") int id){
        ProductResponse productResponse = productService.getProductById(id);
        return new ResponseEntity<>(
                new MessageResponse<>(productResponse, true,
                        "Get product by id success",
                        "200"
                )
                , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(
            @RequestBody ProductRequest request
    ){
        productService.createProduct(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Object> updateProduct(
            @RequestBody ProductRequest request
    ){
        productService.update(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(
            @PathVariable int id,
            @RequestBody ProductRequest request
    ){
        productService.delete(id, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/category/{category-id}")
    public ResponseEntity<?> getAllProductsByCategoryId(
            @PathVariable("category-id") int id
    ){
        return new ResponseEntity<>(
                productService.getAllProductsByCategoryId(id),
                HttpStatus.OK
        );
    }
}
