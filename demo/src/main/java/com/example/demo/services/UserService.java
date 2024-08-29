package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.models.LoginModel;
import com.example.demo.repositories.UserRepo;

import jakarta.validation.Valid;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User checkLogin(@Valid LoginModel object) {
        Optional<User> optional = userRepo.findByEmailAndPassword(object.getEmail(), object.getPassword());

        if (optional.isPresent())
            return optional.get();
        else
            return null;
    }

}
