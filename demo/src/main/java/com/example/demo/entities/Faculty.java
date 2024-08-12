package com.example.demo.entities;

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
    private String fac_id;

    @Column(name = "phone", nullable = false)
    private String phone;
}
