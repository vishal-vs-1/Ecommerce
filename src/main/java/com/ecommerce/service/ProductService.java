package com.ecommerce.service;

import com.ecommerce.requests.AddProductRequest;
import com.ecommerce.requests.AuthenticateRequest;
import com.ecommerce.requests.RegistrationRequest;

import java.util.List;

public interface ProductService {

    String addProduct(AddProductRequest req);

    String addProducts(List<AddProductRequest> req);
}
