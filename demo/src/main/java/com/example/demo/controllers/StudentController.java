package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/student")
public class StudentController extends BaseController {
    @GetMapping("")
    public String hello() {
        return new String("Hello from student controller");
    }
}
