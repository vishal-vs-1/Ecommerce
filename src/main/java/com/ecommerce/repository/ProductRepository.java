package com.ecommerce.repository;

import com.ecommerce.constants.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("SELECT p FROM Product p JOIN p.categories c WHERE c = :category")
    List<Product> findProductByCategory(@Param("category") Category category);

    @Query(value = "SELECT * FROM product ORDER BY RAND() LIMIT 4", nativeQuery = true)
    List<Product> findPopularProducts();

    @Query(value = "SELECT * FROM product ORDER BY RAND() LIMIT 8", nativeQuery = true)
    List<Product> findNewCollections();
}
