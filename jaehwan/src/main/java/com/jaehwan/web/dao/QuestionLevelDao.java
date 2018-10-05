package com.jaehwan.web.dao;

import java.util.List;

import com.jaehwan.web.entity.QuestionLevel;

public interface QuestionLevelDao {
	
	int insert(QuestionLevel level);
	int update(QuestionLevel level);
	int delete(long id);
	
	QuestionLevel get(long id);
	List<QuestionLevel> getList();
}
