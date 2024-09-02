package com.example.demo.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.models.FacultyRegister;
import com.example.demo.models.LoginModel;
import com.example.demo.models.LoginResponse;
import com.example.demo.models.StudentRegister;
import com.example.demo.services.FacultyService;
import com.example.demo.services.StudentService;
import com.example.demo.services.UserService;
import com.example.demo.utils.ApiResponse;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/public")
public class PublicControllers extends BaseController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    private HashMap<String, String> roles;

    public PublicControllers() {
        roles = new HashMap<>();
        roles.put("ROLE_ADMIN", "admin");
        roles.put("ROLE_FACULTY", "faculty");
        roles.put("ROLE_STUDENT", "student");
    }

    // Test Mapping for public routes
    @GetMapping("")
    public String hello() {
        return new String("Hello from public controller");
    }

    // Post mapping for student registration
    @PostMapping("/register/student")
    public ApiResponse registerStudent(@Valid @RequestBody StudentRegister object) {
        object.setPassword(encoder.encode(object.getPassword()));
        return studentService.register(object);
    }

    // Post mapping for faculty registration
    @PostMapping("/register/faculty")
    public ApiResponse registerFaculty(@Valid @RequestBody FacultyRegister object) {
        object.setPassword(encoder.encode(object.getPassword()));
        return facultyService.register(object);
    }

    // Post mapping for login
    @PostMapping("/login")
    public ApiResponse login(@Valid @RequestBody LoginModel object) {
        try {
            
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(object.getEmail(), object.getPassword()));
            User user = (User) userService.loadUserByUsername(object.getEmail());

            if (user == null) {
                return new ApiResponse(false, null, "Invalid User, Login Failed!", null);
            } else {
                LoginResponse response = new LoginResponse(user.getName(), null, user.getRole());
                return new ApiResponse(true, response, "Login Success", null);
            }
        } catch (Exception ex) {
            return new ApiResponse(false, null, "Invalid User, Login Failed!", null);
        }
    }

}