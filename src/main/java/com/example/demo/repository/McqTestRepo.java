package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.McqTest;



public interface McqTestRepo extends JpaRepository<McqTest, Integer>{
	
	List<McqTest> findBytitle(String title);
}
