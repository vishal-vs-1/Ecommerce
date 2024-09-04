package com.ecommerce.service.impl;

import com.ecommerce.constants.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ProductNotFoundException;
import com.ecommerce.mapper.ProductMapper;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.requests.AddProductRequest;
import com.ecommerce.requests.RegistrationRequest;
import com.ecommerce.response.ProductResponse;
import com.ecommerce.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public String addProduct(AddProductRequest req) {
        try {
            Product product = ProductMapper.addProduct(req);
            productRepository.save(product);
        } catch (Exception ex) {
            log.info(ex.getMessage());
            throw ex;
        }
        return "Product added successfully";
    }

    @Override
    public String addProducts(List<AddProductRequest> req) {
        try {
            req.forEach(request -> {
                Product product = ProductMapper.addProduct(request);
                productRepository.save(product);
            });
        } catch (Exception ex) {
            log.info(ex.getMessage());
            throw ex;
        }
        return "Products added successfully";
    }

    @Override
    public ProductResponse getProductById(int id) {
        Product product = productRepository
                .findById(id)
                .orElseThrow(
                        () -> new ProductNotFoundException("INVALID.PRODUCT.ID")
                );

        return ProductMapper.getProduct(product);
    }

    @Override
    public List<ProductResponse> getProductsByCategory(String category) {
        List<Product> productList = productRepository
                .findProductByCategory(Category.valueOf(category));

        if(productList.isEmpty())
            throw new ProductNotFoundException("NO.PRODUCT.FOR.CATEGORY");
        return productList.stream().map(ProductMapper::getProduct).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllCategories() {
        List<String> categoriesList = new ArrayList<>();
        for(Category c: Category.values()){
            categoriesList.add(c.toString());
        }
        return categoriesList;
    }

    @Override
    public List<ProductResponse> getPopularProducts() {
        List<ProductResponse> list = productRepository.findPopularProducts().stream().map(ProductMapper::getProduct).toList();
        return list;
    }

    @Override
    public List<ProductResponse> getNewCollection() {
        List<ProductResponse> list = productRepository.findNewCollections().stream().map(ProductMapper::getProduct).toList();
        return list;
    }

    @Override
    public List<ProductResponse> getByDiscounts(int discount, String category) {
        List<ProductResponse> list = productRepository.findByDiscount(discount, Category.valueOf(category)).stream().map(ProductMapper::getProduct).toList();
        return list;
    }
}
