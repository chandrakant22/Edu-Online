package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Chat;
import java.lang.String;

public interface ChatRepository extends JpaRepository<Chat, Integer>{
	
 List<Chat> findByTeacherName(String teachername);
 List<Chat> findByStudentNameAndTeacherName(String studentName, String teachername);
 
 @Query("SELECT DISTINCT c.studentName FROM Chat c WHERE c.teacherName=:teacherName")
 List<String> getDistinctStudentByTeacherName(String teacherName);
}
