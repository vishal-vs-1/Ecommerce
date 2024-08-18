package com.ecommerce.requests;

import lombok.Data;

@Data
public class AddToCartRequest {

    private int productId;
    private int productName;
    private int quantity;
}
