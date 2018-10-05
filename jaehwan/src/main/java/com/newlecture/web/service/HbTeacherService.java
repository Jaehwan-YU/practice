package com.newlecture.web.service;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaehwan.web.dao.QuestionLevelDao;
import com.jaehwan.web.dao.QuestionDao;
import com.jaehwan.web.dao.SubjectDao;
import com.jaehwan.web.entity.QuestionLevel;
import com.jaehwan.web.entity.Question;
import com.jaehwan.web.entity.Subject;

@Service
public class HbTeacherService implements TeacherService{

	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private QuestionLevelDao levelDao;
	@Autowired
	private QuestionDao questionDao;
	
	public List<Subject> getSubjectList() {
		return subjectDao.getList();
	}

	public List<QuestionLevel> getLevelList() {
		return levelDao.getList();
	}

	public List<Question> getQuestionList() {
		return getQuestionList("", null,"regDate",1);
	}

	public List<Question> getQuestionList(String query) {
		return getQuestionList(query, null ,"regDate",1);
	}

	public List<Question> getQuestionList(String query, int page) {	
		return getQuestionList(query, null, "regDate", page);
	}

	public List<Question> getQuestionList(String query, String ownerId, int page) {
		return getQuestionList(query, ownerId, "regDate", page);	
	}

	public List<Question> getQuestionList(String query,  String ownerId, String sortField, int page) {
		return questionDao.getList(query, ownerId, sortField, page);
	}

}
