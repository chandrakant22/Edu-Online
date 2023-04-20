package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enrolledCourses")
public class CourseEnrolled {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String studentEmail;
	@Column
	private String enrolledCourse;
	
	
	public CourseEnrolled() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CourseEnrolled(String studentEmail, String enrolledCourse) {
		super();
		this.studentEmail = studentEmail;
		this.enrolledCourse = enrolledCourse;
	}

	public CourseEnrolled(int id, String studentEmail, String enrolledCourse) {
		super();
		this.id = id;
		this.studentEmail = studentEmail;
		this.enrolledCourse = enrolledCourse;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getEnrolledCourse() {
		return enrolledCourse;
	}

	public void setEnrolledCourse(String enrolledCourse) {
		this.enrolledCourse = enrolledCourse;
	}

	@Override
	public String toString() {
		return "CourseEnrolled [id=" + id + ", studentEmail=" + studentEmail + ", enrolledCourse=" + enrolledCourse
				+ "]";
	}
	
	
	
	

}
