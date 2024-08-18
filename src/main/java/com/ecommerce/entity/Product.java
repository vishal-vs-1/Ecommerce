package com.ecommerce.entity;

import com.ecommerce.constants.Category;
import com.ecommerce.constants.Size;
import com.ecommerce.constants.Tag;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private int quantity;
    private String description;
    private double cost;
    private int discount;
    private String imageUrl;

    @CollectionTable
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Size.class)
    private List<Size> sizes;

    @CollectionTable
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Category.class)
    private List<Category> categories;

    @CollectionTable
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Tag.class)
    private List<Tag> tags;

    @OneToMany
    @JoinColumn(name = "reviewId")
    private List<Review> reviews;
}
