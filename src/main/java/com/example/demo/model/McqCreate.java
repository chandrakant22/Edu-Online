package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mcqcreate_tbl")
public class McqCreate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	@Column(length = 500)
	private String titel;
	@Column(length = 500)
	private String subject;
	@Column(length = 500)
	private String email;
	@Column(length = 500)
	private String time;
	
	public McqCreate() {
		super();
	}

	public McqCreate(String titel, String subject, String email, String time) {
		super();
		this.titel = titel;
		this.subject = subject;
		this.email = email;
		this.time = time;
	}
	
	
	public McqCreate(int mid, String titel, String subject, String email, String time) {
		super();
		this.mid = mid;
		this.titel = titel;
		this.subject = subject;
		this.email = email;
		this.time = time;
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	
	public void show() {
		System.out.println( "McqCreate [mid=" + mid + ", titel=" + titel + ", subject=" + subject + ", email=" + email + ", time="
				+ time + "]");
	}
	
	

}
