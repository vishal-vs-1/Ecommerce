package com.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
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
    @JoinColumn(name = "userId")
	private List<Address> address;

    @OneToMany
    @JoinColumn(name = "userId")
	private List<CartItem> cartItems;

    @OneToMany
    @JoinColumn(name = "reviewId")
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userId"),
                inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Role> roles;

    @OneToMany
    @JoinColumn(name = "userId")
    private List<Order> orders;
}
