package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "codeGen_tbl")
public class CodeGenerator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	@Column
	private String code;
	@Column
	private int user;
	
	
	
	
	public CodeGenerator(String code) {
		super();
		this.code = code;
	}
	public CodeGenerator(String code, int user) {
		super();
		this.code = code;
		this.user = user;
	}
	public CodeGenerator(int cid, String code, int user) {
		super();
		this.cid = cid;
		this.code = code;
		this.user = user;
	}
	public CodeGenerator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	
	
	
	
	

}
