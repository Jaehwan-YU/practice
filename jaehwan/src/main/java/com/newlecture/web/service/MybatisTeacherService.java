package com.newlecture.web.service;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaehwan.web.dao.LevelDao;
import com.jaehwan.web.dao.QuestionDao;
import com.jaehwan.web.dao.SubjectDao;
import com.jaehwan.web.entity.Level;
import com.jaehwan.web.entity.Question;
import com.jaehwan.web.entity.Subject;

@Service
public class MybatisTeacherService implements TeacherService {

	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private LevelDao levelDao;
	@Autowired
	private QuestionDao questionDao;
	
	@Override
	public List<Subject> getSubjectList() {
		
		return null;
	}

	@Override
	public List<Level> getLevelList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getQuestionList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getQuestionList(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getQuestionList(String query, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getQuestionList(String query, boolean all, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getQuestionList(String query, boolean all, String sortField, int page) {
		// TODO Auto-generated method stub
		return null;
	}

}
