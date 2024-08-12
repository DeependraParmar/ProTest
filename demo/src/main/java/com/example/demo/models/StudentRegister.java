package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegister {
    private String name;
    private String branch;
    private String enrollNumber;
    private int semester;
    private String email;
    private String password;
}
