package com.example.demo.entities;

import com.example.demo.models.FacultyRegister;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "faculty")
@NoArgsConstructor
@AllArgsConstructor
public class Faculty extends User {
    @Column(name = "fac_id", nullable = false, unique = true)
    private Integer fac_id;

    @Column(name = "phone", nullable = false)
    private String phone;

    public Faculty(FacultyRegister object) {
        this.fac_id = object.getFac_id();
        this.phone = object.getPhone();
        this.setName(object.getName());
        this.setEmail(object.getEmail());
        this.setPassword(object.getPassword());
        this.setRole("ROLE_FACULTY");
    }
}
