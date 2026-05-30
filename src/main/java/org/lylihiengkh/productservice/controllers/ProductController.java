package org.lylihiengkh.productservice.controllers;

import lombok.RequiredArgsConstructor;
import org.lylihiengkh.productservice.dto.request.ProductRequest;
import org.lylihiengkh.productservice.dto.response.ProductResponse;
import org.lylihiengkh.productservice.services.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?>getAllProducts(){
        return new ResponseEntity<>(
                productService.getAllProducts(),
                HttpStatus.OK);
    }
    // /api/v1/products/1
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") int id ){
        ProductResponse productResponse = productService.getProductById(id);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(
        @RequestBody ProductRequest request
    ){
        productService.createProduct(request);
        return new ResponseEntity<>((HttpHeaders) null, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> updateProduct(
        @RequestBody ProductRequest request
    ){
        productService.update(request);
        return new ResponseEntity<>((HttpHeaders) null, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(
            @PathVariable("id") int id,
            @RequestBody ProductRequest request
    ){
        productService.delete(id,request);
        return new ResponseEntity<>((HttpHeaders) null, HttpStatus.OK);
    }
}
