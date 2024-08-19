package com.ecommerce.controller;

import com.ecommerce.requests.AddProductRequest;
import com.ecommerce.response.ProductResponse;
import com.ecommerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @PostMapping("/add/product")
    public ResponseEntity<String> addProduct(@RequestBody AddProductRequest req){
        return ResponseEntity.ok(productService.addProduct(req));
    }

    @PostMapping("/add/products")
    public ResponseEntity<String> addProducts(@RequestBody List<AddProductRequest> req){
        return ResponseEntity.ok(productService.addProducts(req));
    }

    @GetMapping("product/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable int id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("products")
    public ResponseEntity<List<ProductResponse>> getProductsByCategory(@RequestParam String category){
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<String>> getAllCategories(){
        return ResponseEntity.ok(productService.getAllCategories());
    }

    @GetMapping("/products/popular")
    public ResponseEntity<List<ProductResponse>> getPopularProducts(){
        return ResponseEntity.ok(productService.getPopularProducts());
    }

    @GetMapping("/products/nc")
    public ResponseEntity<List<ProductResponse>> getNewCollection(){
        return ResponseEntity.ok(productService.getNewCollection());
    }

}
