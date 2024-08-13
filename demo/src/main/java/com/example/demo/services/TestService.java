package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.QuestionRepo;
import com.example.demo.repositories.TestRepo;

@Service
public class TestService {
    @Autowired
    private TestRepo testRepo;

    @Autowired
    private QuestionRepo questionRepo;
}
