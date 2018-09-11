package com.jaehwan.web.service;

import java.util.List;

import com.jaehwan.web.entity.Level;
import com.jaehwan.web.entity.Question;
import com.jaehwan.web.entity.Subject;

public interface TeacherService {
	
	List<Subject> getSubjectList();
	List<Level> getLevelList();
	List<Question> getQuestionList(); 
	List<Question> getQuestionList(String query);
	List<Question> getQuestionList(String query, int page);
	List<Question> getQuestionList(String query, boolean all, int page);
	List<Question> getQuestionList(String query, boolean all, String sortField, int page);
	
}
