package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User {
    @Column(name = "enrollment_number", nullable = false, unique = true)
    private String enrollNumber;

    @Column(name = "branch", nullable = false)
    private String branch;

    @Column(name = "semester", nullable = false)
    private String semester;
}
