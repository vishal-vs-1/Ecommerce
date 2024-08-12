package com.ecommerce.response;

import com.ecommerce.constants.Category;
import com.ecommerce.constants.Size;
import com.ecommerce.constants.Tag;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductResponse {

    private int productId;
    private String productName;
    private int quantity;
    private String description;
    private double cost;
    private int discount;
    private List<Size> sizes;
    private List<Category> categories;
    private List<Tag> tags;

}
