package com.ecommerce.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartProductDto {

    private String imageUrl;
    private double cost;
    private int discount;

    public CartProductDto(String imageUrl, double cost, int discount) {
        this.imageUrl = imageUrl;
        this.cost = cost;
        this.discount = discount;
    }
}
