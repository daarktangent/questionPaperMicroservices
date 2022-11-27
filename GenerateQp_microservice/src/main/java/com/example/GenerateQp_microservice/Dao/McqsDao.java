package com.example.GenerateQp_microservice.Dao;

import com.example.GenerateQp_microservice.Entity.Mcqs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface McqsDao extends JpaRepository<Mcqs,Long> {
    public List<Mcqs> findAll();
}
