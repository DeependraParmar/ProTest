package com.example.demo.utils;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.models.StudentRegister;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@Component
public class ObjectValidator {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public Set<String> validate(StudentRegister objectToValidate){
        Set<ConstraintViolation<StudentRegister>> violations =  validator.validate(objectToValidate);

        if(!violations.isEmpty()){
            return violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet());
        }

        return Collections.emptySet();
    }
}
