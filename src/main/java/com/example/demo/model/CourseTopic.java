package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "course_topics")
public class CourseTopic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int topicId;
	
	@Column
	private int courseId;
	
	@Column
	private String courseTitle;
	@Column
	private String authorEmail;
	@Column
	private String topicName;
	@Column
	private String youtubeLink;
	
	//private String topicImage;
	
	public CourseTopic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseTopic(int topicId, int courseId, String courseTitle, String authorEmail, String topicName,
			String youtubeLink) {
		super();
		this.topicId = topicId;
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.authorEmail = authorEmail;
		this.topicName = topicName;
		this.youtubeLink = youtubeLink;
	}

	public CourseTopic(int courseId, String courseTitle, String authorEmail, String topicName, String youtubeLink) {
		super();
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.authorEmail = authorEmail;
		this.topicName = topicName;
		this.youtubeLink = youtubeLink;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getYoutubeLink() {
		return youtubeLink;
	}

	public void setYoutubeLink(String youtubeLink) {
		this.youtubeLink = youtubeLink;
	}

	@Override
	public String toString() {
		return "CourseTopic [topicId=" + topicId + ", courseId=" + courseId + ", courseTitle=" + courseTitle
				+ ", authorEmail=" + authorEmail + ", topicName=" + topicName + ", youtubeLink=" + youtubeLink + "]";
	}
	
	
	

	
}
