package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.models.LoginModel;
import com.example.demo.repositories.UserRepo;

import jakarta.validation.Valid;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    public User checkLogin(@Valid LoginModel object) {
        Optional<User> optional = userRepo.findByEmailAndPassword(object.getEmail(), object.getPassword());

        if (optional.isPresent())
            return optional.get();
        else
            return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> op = userRepo.findByEmail(username);

        if(op.isPresent())
            return op.get();
        else
            return null;
    }

    public User getById(int userid){
        Optional<User> op = userRepo.findById(userid);

        if(op.isPresent())
            return op.get();
        else
            return null;
    }
}
