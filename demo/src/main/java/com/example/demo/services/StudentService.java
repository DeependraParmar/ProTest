package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.models.StudentRegister;
import com.example.demo.repositories.StudentRepo;
import com.example.demo.utils.ApiResponse;
import com.example.demo.utils.ObjectValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    
    private final ObjectValidator<StudentRegister> validator;

    public ApiResponse register(StudentRegister object) {
        try {
            var violations = validator.validate(object);

            if(!violations.isEmpty()){
                String violationString = String.join(" | ", violations);
                return new ApiResponse(false, violationString, "Validation Failed!", null);
            }

            Student student = new Student(object);
            studentRepo.save(student);
            return new ApiResponse(true, null, "Student Registration Successfull", null);
        } catch (Exception e) {
            return new ApiResponse(false, "Student Registration Failed!", e.getMessage());
        }
    }
    
}
