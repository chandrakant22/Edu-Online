package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Teacher;

public interface TeacherService {

	List <Teacher> getAllTeachers();
	void saveTeacher(Teacher t);
	void deleteTeacher(Teacher t);
	Optional <Teacher> getTeacherById(int id);
}
