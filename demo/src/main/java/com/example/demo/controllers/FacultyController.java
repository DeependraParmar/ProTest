package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.QuestionModel;
import com.example.demo.models.TestModel;
import com.example.demo.services.TestService;
import com.example.demo.utils.ApiResponse;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth/faculty")
public class FacultyController extends BaseController {
    @Autowired
    private TestService testService;

    @GetMapping("")
    public String hello() {
        return new String("Hello from faculty controller");
    }

    // Post mapping for creating a new test
    @PostMapping("/test/create")
    public ApiResponse createTest(@Valid @RequestBody TestModel object) {
        return testService.saveTest(object);
    }
    
    // Post mapping for adding questions in a test
    @PostMapping("/test/add/question/{testid}")
    public ApiResponse addQuestion(@Valid @RequestBody QuestionModel object, @PathVariable(value = "testid") Integer test_id) {
        //TODO: process POST request
        
        return testService.saveQuestion(object, test_id);
    }
    
}
