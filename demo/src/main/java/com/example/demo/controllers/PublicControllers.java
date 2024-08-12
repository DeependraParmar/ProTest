package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.StudentRegister;
import com.example.demo.services.StudentService;
import com.example.demo.utils.ApiResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/public")
public class PublicControllers {
    @Autowired
    private StudentService studentService;

    // Test Mapping for public routes
    @GetMapping("")
    public String hello() {
        return new String("Hello from public controller");
    }
    

    // Post mapping for student registration
    @PostMapping("/register/student")
    public ApiResponse registerStudent(@RequestBody StudentRegister object) {
        return studentService.register(object);
    }
    
}