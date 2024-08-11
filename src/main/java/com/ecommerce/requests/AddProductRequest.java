package com.ecommerce.requests;

import com.ecommerce.constants.Category;
import com.ecommerce.constants.Size;
import com.ecommerce.constants.Tag;
import com.ecommerce.entity.Review;
import lombok.Data;

import java.util.List;

@Data
public class AddProductRequest {

    private String productName;
    private int quantity;
    private String description;
    private double cost;
    private int discount;
    private List<Size> sizes;
    private List<Category> categories;
    private List<Tag> tags;

}
