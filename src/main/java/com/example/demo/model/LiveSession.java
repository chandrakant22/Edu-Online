package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "live_session_tbl2")
public class LiveSession {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "topic_name", nullable = false)
	private String topic_name;
	@Column(name = "subject", nullable = false)
	private String subject;
	@Column(name = "date", nullable = false)
	private String date;
	@Column(name = "time", nullable = false)
	private String time;
	@Column(name = "link", nullable = false)
	private String link;
	
	public LiveSession() {
		super();
	}
	
	public LiveSession(String topic_name, String subject, String date, String time, String link) {
		super();
		this.topic_name = topic_name;
		this.subject = subject;
		this.date = date;
		this.time = time;
		this.link = link;
	}
	
	public LiveSession(int id, String topic_name, String subject, String date, String time, String link) {
		super();
		this.id = id;
		this.topic_name = topic_name;
		this.subject = subject;
		this.date = date;
		this.time = time;
		this.link = link;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTopic_name() {
		return topic_name;
	}
	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	@Override
	public String toString() {
		return "Live_Session [id=" + id + ", topic_name=" + topic_name + ", subject=" + subject + ", date=" + date
				+ ", time=" + time + ", link=" + link + "]";
	}
	
	
}
