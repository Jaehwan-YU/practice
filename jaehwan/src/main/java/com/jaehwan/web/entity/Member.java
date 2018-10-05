package com.jaehwan.web.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//테이블 명이 클래스 명과 다를경우 @Table(name="User")
public class Member {
	@Id
	@Column(updatable=false)
	private String id;
	private String name;
	private String email;
	private String pwd;
	@Column(insertable=false, updatable=false)
	private Date regDate;
	//컬럼 명이 속성명과 다를경우 @Column(name="FOTO")
	private String photo;
	
	public Member() {
		
	}
	
	public Member(String id, String name, String email, String pwd, Date regDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.regDate = regDate;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", regDate=" + regDate
				+ ", photo=" + photo + "]";
	}
	
	
}
