package com.example.demo.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestModel {
    @NotNull(message = "Title can't be Null")
    @NotEmpty(message = "Title can't be Not Empty")
    private String title;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "Test Date can't be Null")
    private LocalDate date;
}