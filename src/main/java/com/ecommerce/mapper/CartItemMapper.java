package com.ecommerce.mapper;

import com.ecommerce.entity.CartItem;
import com.ecommerce.requests.AddToCartRequest;

public class CartItemMapper {

    public static CartItem addToCart(AddToCartRequest req){
        return CartItem.builder()
                .productName(req.getProductName())
                .productId(req.getProductId())
                .quantity(req.getQuantity())
                .size(req.getSize())
                .build();
    }


}
