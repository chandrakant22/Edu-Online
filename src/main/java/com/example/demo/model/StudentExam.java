package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="check_mcq")
public class StudentExam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String queid;
	@Column
	private String selectedAns;
	@Column
	private String studentEmail;
	
	public StudentExam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentExam(int id, String queid, String selectedAns, String studentEmail) {
		super();
		this.id = id;
		this.queid = queid;
		this.selectedAns = selectedAns;
		this.studentEmail = studentEmail;
	}

	public StudentExam(String queid, String selectedAns, String studentEmail) {
		super();
		this.queid = queid;
		this.selectedAns = selectedAns;
		this.studentEmail = studentEmail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQueid() {
		return queid;
	}

	public void setQueid(String queid) {
		this.queid = queid;
	}

	public String getSelectedAns() {
		return selectedAns;
	}

	public void setSelectedAns(String selectedAns) {
		this.selectedAns = selectedAns;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	@Override
	public String toString() {
		return "StudentExam [id=" + id + ", queid=" + queid + ", selectedAns=" + selectedAns + ", studentEmail="
				+ studentEmail + "]";
	}

	

}
