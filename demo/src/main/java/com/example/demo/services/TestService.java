package com.example.demo.services;

import java.util.Optional;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Questions;
import com.example.demo.entities.Test;
import com.example.demo.models.QuestionModel;
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

    public ApiResponse saveQuestion(QuestionModel object, Integer test_id) {
        try {
            Optional<Test> searchedTest = testRepo.findById(test_id);

            if(searchedTest.isEmpty()){
                return new ApiResponse(false, null, "Invalid Test!", null
                );
            }
            else{
                Questions question = new Questions(object);
                question.setTest(searchedTest.get());
                questionRepo.save(question);
                return new ApiResponse(true, null, "Question added successfully!", null);
            }            
        } catch (Exception e) {
            return new ApiResponse(false, null, "Error adding question!", e.getMessage());
        }
    }
}
