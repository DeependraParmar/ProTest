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
public class Faculty extends User {
    @Column(name = "faculty_id", nullable = false, unique = true)
    private String fac_id;

    @Column(name = "phone", nullable = false)
    private String phone;
}
