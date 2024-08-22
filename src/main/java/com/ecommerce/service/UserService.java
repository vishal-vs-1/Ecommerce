package com.ecommerce.service;

import com.ecommerce.requests.AddToCartRequest;

import java.util.List;

public interface UserService {

    void addProductToCart(AddToCartRequest req);
    String removeProductFromCart(int id);
    String orderItems();
    int getCarItemsCount();

}
