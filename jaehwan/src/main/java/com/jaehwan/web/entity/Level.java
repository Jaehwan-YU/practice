package com.jaehwan.web.entity;

import java.sql.Date;

public class Level {
	
	private long id;
	private String title;
	private String description;
	private Date regDate;
	private String regUserId;
	
	public Level() {
		
	}
	
	public Level(long id, String title, String description, String regUserId) {
		
		this.title = title;
		this.description = description;
		this.regUserId = regUserId;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
		return "Subject [id=" + id + ", title=" + title + ", description=" + description + ", regDate=" + regDate
				+ ", regUserId=" + regUserId + "]";
	}
	
	
}
