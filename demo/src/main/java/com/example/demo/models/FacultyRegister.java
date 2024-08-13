package com.example.demo.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacultyRegister {
    @NotNull(message = "Name can't be Null")
    @NotEmpty(message = "Name can't be empty")
    private String name;

    @NotNull(message = "Faculty Id can't be Null")
    private Integer fac_id;

    @NotNull(message = "Email can't be Null")
    @NotEmpty(message = "Email can't be empty")
    private String email;

    @NotNull(message = "Password can't be Null")
    @NotEmpty(message = "Password can't be empty")
    private String password;
    
    @NotNull(message = "Phone Number can't be Null")
    @NotEmpty(message = "Phone Number can't be empty")
    private String phone;
}
