package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Faculty;

public interface FacultyRepo extends JpaRepository<Faculty, Integer> {

}
