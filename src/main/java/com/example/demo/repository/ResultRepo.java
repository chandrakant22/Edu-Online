package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Result;

public interface ResultRepo extends JpaRepository<Result, Integer>{
	
	Result findByUsernameAndSubject(String username, String subject);

}
