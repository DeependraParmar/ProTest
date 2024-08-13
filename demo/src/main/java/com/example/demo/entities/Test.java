package com.example.demo.entities;

import java.time.LocalDate;

import com.example.demo.models.TestModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tests")
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    @Id
    @Column(name = "test_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "test_title", nullable = false)
    private String title;

    @Column(name = "test_date", nullable = false)
    private LocalDate testDate;

    @Column(name = "post_date", nullable = false)
    private LocalDate postDate;

    @Column(name = "status", nullable = false)
    private Boolean status;


    public Test(@Valid TestModel object) {
        this.title = object.getTitle();
        this.testDate = object.getDate();
        this.postDate = LocalDate.now();
        this.status = true;
    }
}
