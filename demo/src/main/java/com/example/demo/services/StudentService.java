package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.models.StudentRegister;
import com.example.demo.repositories.StudentRepo;
import com.example.demo.utils.ApiResponse;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public ApiResponse register(StudentRegister object) {
        try {
            Student student = new Student(object);
            studentRepo.save(student);
            return new ApiResponse(true, null, "Student Registration Successfull", null);
        } catch (Exception e) {
            return new ApiResponse(false, "Student Registration Failed!", e.getMessage());
        }
    }
    
}
