package com.example.demo.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegister {

    @NotNull(message = "Name can't be Null")
    @NotEmpty(message = "Name can't be empty")
    private String name;

    @NotNull(message = "Branch can't be Null")
    @NotEmpty(message = "Branch can't be empty")
    private String branch;

    @NotNull(message = "Enrollment Number can't be Null")
    @NotEmpty(message = "Enrollment Number can't be empty")
    private String enrollNumber;

    @NotNull(message = "Semester can't be Null")
    @NotEmpty(message = "Semester can't be empty")
    private int semester;

    @NotNull(message = "Email can't be Null")
    @NotEmpty(message = "Email can't be empty")
    private String email;

    @NotNull(message = "Password can't be Null")
    @NotEmpty(message = "Password can't be empty")
    private String password;
}
