package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherRepository teacherRepo;
	
	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepo.findAll();
	}

	@Override
	public void saveTeacher(Teacher t) {
		teacherRepo.save(t);
	}

	@Override
	public void deleteTeacher(Teacher t) {
		teacherRepo.delete(t);		
	}

	@Override
	public Optional<Teacher> getTeacherById(int id) {
		return teacherRepo.findById(id);
	}

	
		
	

}
