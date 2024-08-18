package com.ecommerce.repository;

import com.ecommerce.entity.CartItem;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartItemRepository extends CrudRepository<CartItem, Integer> {


}
