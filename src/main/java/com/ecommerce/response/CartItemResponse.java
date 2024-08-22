package com.ecommerce.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItemResponse {

    private int productId;
    private String imageUrl;
    private String productName;
    private double price;
    private int quantity;

}
