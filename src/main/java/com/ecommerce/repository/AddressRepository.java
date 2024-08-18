package com.ecommerce.repository;

import com.ecommerce.entity.Address;
import com.ecommerce.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
