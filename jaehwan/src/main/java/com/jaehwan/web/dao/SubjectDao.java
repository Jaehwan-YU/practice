package com.jaehwan.web.dao;

import java.util.List;

import com.jaehwan.web.entity.Subject;

public interface SubjectDao {
	
	int insert(Subject subject);
	int update(Subject subject);
	int delete(long id);
	
	Subject get(long id);
	List<Subject> getList();
	
}
