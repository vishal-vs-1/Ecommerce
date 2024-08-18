package com.ecommerce.repository;

import com.ecommerce.entity.CartItem;
import com.ecommerce.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {


}
