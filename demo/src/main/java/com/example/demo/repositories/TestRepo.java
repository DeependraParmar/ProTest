package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Test;

@Repository
public interface TestRepo extends JpaRepository<Test, Integer> {

}
