package com.newlecture.web.service;

import java.util.List;

import com.jaehwan.web.entity.QuestionLevel;
import com.jaehwan.web.entity.Question;
import com.jaehwan.web.entity.Subject;

public interface TeacherService {
	
	List<Subject> getSubjectList();
	List<QuestionLevel> getLevelList();
	List<Question> getQuestionList(); 
	List<Question> getQuestionList(String query);
	List<Question> getQuestionList(String query, int page);
	List<Question> getQuestionList(String query, String ownerId, int page);
	List<Question> getQuestionList(String query, String ownerId, String sortField, int page);
	
}
