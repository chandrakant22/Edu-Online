package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "results")
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String username;
	@Column
	private String subject;
	@Column
	private int score;
	@Column
	private int totalCorrect = 0;

	public Result() {
		super();
	}

	public Result(int id, String username, int totalCorrect) {
		super();
		this.id = id;
		this.username = username;
		this.totalCorrect = totalCorrect;
	}
	

	public Result(String username, String subject, int score, int totalCorrect) {
		super();
		this.username = username;
		this.subject = subject;
		this.score = score;
		this.totalCorrect = totalCorrect;
	}

	public Result(int id, String username, String subject, int score, int totalCorrect) {
		super();
		this.id = id;
		this.username = username;
		this.subject = subject;
		this.score = score;
		this.totalCorrect = totalCorrect;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getTotalCorrect() {
		return totalCorrect;
	}

	public void setTotalCorrect(int totalCorrect) {
		this.totalCorrect = totalCorrect;
	}
	
	@Override
	public String toString() {
		return "Result [id=" + id + ", username=" + username + ", subject=" + subject + ", score=" + score
				+ ", totalCorrect=" + totalCorrect + "]";
	}

}
