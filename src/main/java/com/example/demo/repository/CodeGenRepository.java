package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CodeGenerator;

public interface CodeGenRepository extends JpaRepository<CodeGenerator, Integer> {
	
	CodeGenerator findByCode(String code);
	
	//CodeGenerator getReferenceByCode(String code);

}
