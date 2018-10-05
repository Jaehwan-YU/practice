package com.jaehwan.web.dao;

import java.util.List;

import com.jaehwan.web.entity.Question;

public interface QuestionDao {
	
	int insert(Question question);
	int update(Question question);
	int delete(long id);
	
	Question get(long id);
	List<Question> getList(String query, String ownerId, String sortField, int page);
	
}
