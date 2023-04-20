package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.McqCreate;
import com.example.demo.model.McqTest;



public interface McqCreateRepo extends JpaRepository<McqCreate, Integer> {
	List<McqCreate> findBySubject(String subject);
}
