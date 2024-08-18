package com.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private int productId;
    private double totalPrice;
    private String productName;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address address;

}
