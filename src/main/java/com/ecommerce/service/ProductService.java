package com.ecommerce.service;

import com.ecommerce.requests.AddProductRequest;
import com.ecommerce.requests.AuthenticateRequest;
import com.ecommerce.requests.RegistrationRequest;
import com.ecommerce.response.ProductResponse;

import java.util.List;

public interface ProductService {

    String addProduct(AddProductRequest req);

    String addProducts(List<AddProductRequest> req);

    ProductResponse getProductById(int id);

    List<ProductResponse> getProductsByCategory(String category);

    List<String> getAllCategories();

    List<ProductResponse> getPopularProducts();

    List<ProductResponse> getNewCollection();

    List<ProductResponse> getByDiscounts(int discount, String category);
}
