package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/public")
public class PublicControllers {

    // Test Mapping for public routes
    @GetMapping("")
    public String hello() {
        return new String("Hello from public controller");
    }
    

    // Post mapping for 
}