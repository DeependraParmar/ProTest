package com.example.demo.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginModel {
    @NotNull(message = "Email can't be Null")
    @NotEmpty(message = "Email can't be empty")
    private String email;

    @NotNull(message = "Password can't be Null")
    @NotEmpty(message = "Password can't be empty")
    private String password;
}
