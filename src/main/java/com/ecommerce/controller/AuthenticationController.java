package com.ecommerce.controller;

import com.ecommerce.requests.AuthenticateRequest;
import com.ecommerce.requests.RegistrationRequest;
import com.ecommerce.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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

    @GetMapping("/check/admin/test")
    boolean test(){
        boolean admin = false;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            System.out.println(authority.getAuthority());
            if(Objects.equals(authority.getAuthority(), "ADMIN")){
                admin = true;
            }
        }
        System.out.println(admin);
        return admin;
    }

}
