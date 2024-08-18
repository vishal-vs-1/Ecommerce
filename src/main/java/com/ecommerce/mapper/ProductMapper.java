package com.ecommerce.mapper;

import com.ecommerce.entity.Product;
import com.ecommerce.requests.AddProductRequest;
import com.ecommerce.response.ProductResponse;

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
                .imageUrl(req.getImageUrl())
                .build();
    }

    public static ProductResponse getProduct(Product details){
        return ProductResponse.builder()
                .productId(details.getProductId())
                .productName(details.getProductName())
                .quantity(details.getQuantity())
                .description(details.getDescription())
                .cost(details.getCost())
                .discount(details.getDiscount())
                .sizes(details.getSizes())
                .categories(details.getCategories())
                .tags(details.getTags())
                .imageUrl(details.getImageUrl())
                .build();
    }
}