package com.ecommerce.mapper;

import com.ecommerce.entity.Product;
import com.ecommerce.requests.AddProductRequest;

public class ProductMapper {

    public static Product addProduct(AddProductRequest req){
        return Product.builder()
                .productName(req.getProductName())
                .quantity(req.getQuantity())
                .cost(req.getCost())
                .description(req.getDescription())
                .discount(req.getDiscount())
                .sizes(req.getSizes())
                .categories(req.getCategories())
                .tags(req.getTags())
                .build();
    }
}
