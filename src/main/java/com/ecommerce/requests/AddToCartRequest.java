package com.ecommerce.requests;

import com.ecommerce.constants.Size;
import lombok.Data;

@Data
public class AddToCartRequest {

    private int productId;
    private int productName;
    private int quantity;
    private Size size;

}
