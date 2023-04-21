package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chat")
public class Chat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	private String teacherName;
	@Column
	private String studentName;
	@Column
	private String teacherMessage;
	@Column
	private String studentMessage;
	
	
	
	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Chat(int id, String teacherName, String studentName, String teacherMessage, String studentMessage) {
		super();
		this.id = id;
		this.teacherName = teacherName;
		this.studentName = studentName;
		this.teacherMessage = teacherMessage;
		this.studentMessage = studentMessage;
	}


	public Chat(String teacherName, String studentName, String teacherMessage, String studentMessage) {
		super();
		this.teacherName = teacherName;
		this.studentName = studentName;
		this.teacherMessage = teacherMessage;
		this.studentMessage = studentMessage;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getTeacherMessage() {
		return teacherMessage;
	}


	public void setTeacherMessage(String teacherMessage) {
		this.teacherMessage = teacherMessage;
	}


	public String getStudentMessage() {
		return studentMessage;
	}


	public void setStudentMessage(String studentMessage) {
		this.studentMessage = studentMessage;
	}


	@Override
	public String toString() {
		return "Chat [id=" + id + ", teacherName=" + teacherName + ", studentName=" + studentName + ", teacherMessage="
				+ teacherMessage + ", studentMessage=" + studentMessage + "]";
	}
	
	
	
	
	
	
}
