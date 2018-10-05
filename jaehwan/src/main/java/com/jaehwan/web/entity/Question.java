package com.jaehwan.web.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Question {
	
	@Id
	@Column(updatable=false)
	private long id;
	private String content;
	private String figure;
	@Column(insertable=false, updatable=false)
	private Date regDate;
	private String regUserId;
	
	public Question() {
		// TODO Auto-generated constructor stub
	}
	
	public Question(String content, String figure, String regUserId) {
		this.content = content;
		this.figure = figure;
		this.regUserId = regUserId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFigure() {
		return figure;
	}

	public void setFigure(String figure) {
		this.figure = figure;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getRegUserId() {
		return regUserId;
	}

	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", content=" + content + ", figure=" + figure + ", regDate=" + regDate
				+ ", regUserId=" + regUserId + "]";
	}

}
