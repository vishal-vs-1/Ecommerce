package com.ecommerce.controller;

import com.ecommerce.requests.AddProductRequest;
import com.ecommerce.response.ProductResponse;
import com.ecommerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @PostMapping("/add/product")
    public ResponseEntity<String> addProduct(
            @RequestPart("productDetails") AddProductRequest req,
            @RequestPart("image") MultipartFile file) {
        String name = UUID.randomUUID().toString();
        try {
            // Save the file to the specified directory
            byte[] bytes = file.getBytes();
            System.out.println(file.getOriginalFilename());
            Path path = Paths.get("C:/Users/Vishal/Desktop/ecommerce/ecommerce-frontend/src/Components/Assets/" + name + ".png");
            Files.write(path, bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        req.setImageUrl(name + ".png");
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

    @GetMapping("/products/discount/{percent}")
    public ResponseEntity<List<ProductResponse>> getByDiscounts(@PathVariable int percent, @RequestParam String category){
        return ResponseEntity.ok(productService.getByDiscounts(percent, category));
    }

}
