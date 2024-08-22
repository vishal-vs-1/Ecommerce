package com.ecommerce.entity;

import com.ecommerce.constants.Size;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private int productId;
    private String productName;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private Size size;

}
