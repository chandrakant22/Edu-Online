package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CourseEnrolled;

public interface CourseEnrollRepository extends JpaRepository<CourseEnrolled, Integer>{
	
	List<CourseEnrolled> findByStudentEmail(String email);
	
	CourseEnrolled findByStudentEmailAndEnrolledCourse(String studentEmail, String enrolledCourse);
}
