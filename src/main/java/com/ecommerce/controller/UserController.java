package com.ecommerce.controller;

import com.ecommerce.requests.AddToCartRequest;
import com.ecommerce.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/cartItemsCount")
    ResponseEntity<Integer> getCarItemsCount(){
        return ResponseEntity.ok(userService.getCarItemsCount());
    }

    @PostMapping("add/cart")
    ResponseEntity<String> addProductToCart(@RequestBody AddToCartRequest req){
        userService.addProductToCart(req);
        return ResponseEntity.ok("Product successfully added to cart");
    }

}
