package com.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String email;
    private String password;
    private Long phoneNo;
    private String token;
    @OneToMany
    @JoinColumn(name = "addressId")
	private List<Address> address;

    @ManyToMany
	private List<Product> product;

    @OneToMany
    @JoinColumn(name = "reviewId")
    private List<Review> reviews;
}
