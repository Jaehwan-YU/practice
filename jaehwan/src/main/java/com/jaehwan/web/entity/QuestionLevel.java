package com.jaehwan.web.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QuestionLevel {
	@Id
	@Column(updatable=false)
	private long id;
	private String name;
	private String regUserId;
	@Column(insertable=false, updatable=false)
	private Date regDate;
	private String description;
	
	public QuestionLevel() {
		
	}
	
	public QuestionLevel(long id, String name, String description, String regUserId) {
		
		this.name = name;
		this.description = description;
		this.regUserId = regUserId;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegUserId() {
		return regUserId;
	}
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", description=" + description + ", regDate=" + regDate
				+ ", regUserId=" + regUserId + "]";
	}
	
	
}
