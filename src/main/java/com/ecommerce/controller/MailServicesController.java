package com.ecommerce.controller;

import com.ecommerce.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MailServicesController {

    private MailService mailService;

    @PostMapping("/subscribe/{email}")
    ResponseEntity<String> subscribe(@PathVariable String email){
        mailService.subscribe(email);
        return new ResponseEntity<>("Successful!", HttpStatus.CREATED);
    }
}
