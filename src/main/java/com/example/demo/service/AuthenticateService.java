package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;

@Service
public class AuthenticateService {
	
	@Autowired
	private AdminRepository repoService;
	public boolean authenticate(String email, String password) {
		
		Admin admin = repoService.findByEmail(email);
		
		if(admin != null && admin.getPassword().equals(password)) {
			return true;
		}
		else {
			return false;
		}	
		
	}
	
	@Autowired
	private TeacherRepository teacherService;
	public boolean teacherAuthenticate(String email, String password) {
		
		Teacher teacher = teacherService.findByEmail(email);
		
		if(teacher != null && teacher.getPassword().equals(password)) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	@Autowired
	private StudentRepository studentService;
	public boolean studentAuthenticate(String email, String password) {
		
		Student student = studentService.findByEmail(email);
		
		if(student != null && student.getPassword().equals(password)) {
			return true;
		}
		else {
			return false;
		}	
	}

}
