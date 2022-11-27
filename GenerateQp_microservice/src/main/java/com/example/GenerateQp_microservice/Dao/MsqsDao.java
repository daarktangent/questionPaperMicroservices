package com.example.GenerateQp_microservice.Dao;


import com.example.GenerateQp_microservice.Entity.Msqs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MsqsDao extends JpaRepository<Msqs,Long> {
    public List<Msqs> findAll();
}
