package com.ecommerce.repository;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
