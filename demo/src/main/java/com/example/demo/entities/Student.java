package com.example.demo.entities;

import com.example.demo.models.StudentRegister;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User {
    @Column(name = "enrollment_number", nullable = false, unique = true)
    private String enrollNumber;

    @Column(name = "branch", nullable = false)
    private String branch;

    @Column(name = "semester", nullable = false)
    private Integer semester;

    public Student(StudentRegister object) {
        this.enrollNumber = object.getEnrollNumber();
        this.branch = object.getBranch();
        this.semester = object.getSemester();
        this.setName(object.getName());
        this.setEmail(object.getEmail());
        this.setPassword(object.getPassword());
        this.setRole("student");
    }
}
