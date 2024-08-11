package com.ecommerce.controller;

import com.ecommerce.requests.AuthenticateRequest;
import com.ecommerce.requests.RegistrationRequest;
import com.ecommerce.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Validated
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid RegistrationRequest req){
        return ResponseEntity.ok(service.registerUser(req));
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody AuthenticateRequest req){
        return ResponseEntity.ok(service.authenticateUser(req));
    }

    @GetMapping("/test")
    String test(){
        return "token working";
    }

}
