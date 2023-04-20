package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.StudentExam;
import java.lang.String;
import java.util.List;

public interface StudentExamRepository extends JpaRepository<StudentExam, Integer>{
	
	StudentExam findByQueidAndStudentEmail(String queid, String studentEmail);
	
	StudentExam findByQueid(String queid);

}
