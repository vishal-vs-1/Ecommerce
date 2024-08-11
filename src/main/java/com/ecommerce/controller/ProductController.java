package com.ecommerce.controller;

import com.ecommerce.requests.AddProductRequest;
import com.ecommerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
