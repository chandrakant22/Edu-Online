package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mcqtest_tbl")
public class McqTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qId;
	@Column(length = 500)
	private String que;
	@Column(length = 255)
	private String op1;
	@Column(length = 255)
	private String op2;
	@Column(length = 255)
	private String op3;
	@Column(length = 255)
	private String op4;
	@Column(length = 255)
	private String op5;
	@Column(length = 45)
	private String ans;
	@Column(length = 45)
	private String mrk;
	
	@Column(length = 255)
	private String email;
	@Column(length = 255)
	private String title;

	public McqTest() {
		super();
	}
	
	public McqTest( String que, String op1, String op2, String op3, String op4, String op5, String ans,
			String mrk, String email, String title) {
		super();
	
		this.que = que;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.op5 = op5;
		this.ans = ans;
		this.mrk = mrk;
		this.email = email;
		this.title = title;
	}
	
	
public McqTest(int qId, String que, String op1, String op2, String op3, String op4, String op5, String ans,
			String mrk, String email, String title) {
		super();
		this.qId = qId;
		this.que = que;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.op5 = op5;
		this.ans = ans;
		this.mrk = mrk;
		this.email = email;
		this.title = title;
	}




//
//	public McqTest(String que, String op1, String op2, String op3, String op4, String op5, String ans, String mrk) {
//		super();
//		this.que = que;
//		this.op1 = op1;
//		this.op2 = op2;
//		this.op3 = op3;
//		this.op4 = op4;
//		this.op5 = op5;
//		this.ans = ans;
//		this.mrk = mrk;
//	}
//
//	public McqTest(int qId, String que, String op1, String op2, String op3, String op4, String op5, String ans,
//			String mrk) {
//		super();
//		this.qId = qId;
//		this.que = que;
//		this.op1 = op1;
//		this.op2 = op2;
//		this.op3 = op3;
//		this.op4 = op4;
//		this.op5 = op5;
//		this.ans = ans;
//		this.mrk = mrk;
//	}

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public String getQue() {
		return que;
	}

	public void setQue(String que) {
		this.que = que;
	}

	public String getOp1() {
		return op1;
	}

	public void setOp1(String op1) {
		this.op1 = op1;
	}

	public String getOp2() {
		return op2;
	}

	public void setOp2(String op2) {
		this.op2 = op2;
	}

	public String getOp3() {
		return op3;
	}

	public void setOp3(String op3) {
		this.op3 = op3;
	}

	public String getOp4() {
		return op4;
	}

	public void setOp4(String op4) {
		this.op4 = op4;
	}

	public String getOp5() {
		return op5;
	}

	public void setOp5(String op5) {
		this.op5 = op5;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public String getMrk() {
		return mrk;
	}

	public void setMrk(String mrk) {
		this.mrk = mrk;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void show() {
		System.out.println("McqTest [qId=" + qId + ", que=" + que + ", op1=" + op1 + ", op2=" + op2 + ", op3=" + op3 + ", op4="
				+ op4 + ", op5=" + op5 + ", ans=" + ans + ", mrk=" + mrk + ", email=" + email + ", title=" + title
				+ "]");
	}

	

	
}
