package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Faculty;
import com.example.demo.models.FacultyRegister;
import com.example.demo.repositories.FacultyRepo;
import com.example.demo.utils.ApiResponse;
import com.example.demo.utils.ObjectValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FacultyService {
    @Autowired
    private FacultyRepo facultyRepo;

    private ObjectValidator<FacultyRegister> validator;

    public ApiResponse register(FacultyRegister object){
        try {
            var violations = validator.validate(object);

            if(!violations.isEmpty()){
                String violationString = String.join(" | ", violations);
                return new ApiResponse(false, violationString, "Validation Failed!", null);
            }

            Faculty faculty = new Faculty(object);
            facultyRepo.save(faculty);
            return new ApiResponse(true, null, "Faculty Registration Successfull", null);
        } catch (Exception e) {
            return new ApiResponse(false, "Faculty Registration Failed!", e.getMessage());
        }
    }
}
