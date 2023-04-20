package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>{
	
	Teacher findByEmail(String email);

}
