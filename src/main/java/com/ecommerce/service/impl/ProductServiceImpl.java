package com.ecommerce.service.impl;

import com.ecommerce.entity.Product;
import com.ecommerce.mapper.ProductMapper;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.requests.AddProductRequest;
import com.ecommerce.requests.RegistrationRequest;
import com.ecommerce.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public String addProduct(AddProductRequest req) {
        try {
            Product product = ProductMapper.addProduct(req);
            productRepository.save(product);
        }
        catch (Exception ex){
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
        }
        catch (Exception ex){
            log.info(ex.getMessage());
            throw ex;
        }
        return "Products added successfully";
    }


}
