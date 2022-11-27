package com.example.GenerateQp_microservice.Dao;


import com.example.GenerateQp_microservice.Entity.QuestionPaper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionPaperDao extends JpaRepository<QuestionPaper,Long> {

}
