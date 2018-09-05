package com.jaehwan.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaehwan.web.dao.QuestionDao;
import com.jaehwan.web.entity.Question;

@Repository
public class MybatisQuestionDao implements QuestionDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(Question question) {
		
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		
		return questionDao.insert(question);
	}

	@Override
	public int update(Question question) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.update(question);
	}

	@Override
	public int delete(long id) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return questionDao.delete(id);
	}

	@Override
	public Question get(long id) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return null;
	}

	@Override
	public List<Question> getList() {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		return getList("",false,"",1);
	}

	@Override
	public List<Question> getList(String query, int page) {
		
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		
		return getList(query, false, "", page);
	}

	@Override
	public List<Question> getList(String query, boolean all, int page) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		
		return getList(query, all, "", page);
	}

	@Override
	public List<Question> getList(String query, boolean all, String sortField, int page) {
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		
		return questionDao.getList(query, all, sortField, page);
	}

}
