package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	Course findBycourseTitle(String courseTitle) ;
	
	List<Course> findByStatus(String status);
}
