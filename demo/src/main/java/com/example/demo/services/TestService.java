package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Faculty;
import com.example.demo.entities.Test;
import com.example.demo.models.TestModel;
import com.example.demo.repositories.QuestionRepo;
import com.example.demo.repositories.TestRepo;
import com.example.demo.utils.ApiResponse;

import jakarta.validation.Valid;

@Service
public class TestService {
    @Autowired
    private TestRepo testRepo;

    @Autowired
    private QuestionRepo questionRepo;

    public ApiResponse saveTest(@Valid TestModel object) {
        try {
            Test ob = new Test(object);
            testRepo.save(ob);
            return new ApiResponse(true, null, "Test Created Successfully", null);
        } catch (Exception e) {
            return new ApiResponse(false, null, "Error while creating Test!", e.getMessage());
        }
    }
}
