package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Course;
import com.example.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	Student findByEmail(String email);
}
