package com.jaehwan.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaehwan.web.dao.QuestionLevelDao;
import com.jaehwan.web.entity.QuestionLevel;

@Repository
public class MybatisQuestionLevelDao implements QuestionLevelDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(QuestionLevel level) {
		
		QuestionLevelDao questionLevelDao = sqlSession.getMapper(QuestionLevelDao.class);
		
		return questionLevelDao.insert(level);
	}

	@Override
	public int update(QuestionLevel level) {
		QuestionLevelDao questionLevelDao = sqlSession.getMapper(QuestionLevelDao.class);
		
		return questionLevelDao.update(level);
	}

	@Override
	public int delete(long id) {
		QuestionLevelDao questionLevelDao = sqlSession.getMapper(QuestionLevelDao.class);
		
		return questionLevelDao.delete(id);
	}

	@Override
	public QuestionLevel get(long id) {
		QuestionLevelDao questionLevelDao = sqlSession.getMapper(QuestionLevelDao.class);
		
		return questionLevelDao.get(id);
	}

	@Override
	public List<QuestionLevel> getList() {
		QuestionLevelDao questionLevelDao = sqlSession.getMapper(QuestionLevelDao.class);
		
		return questionLevelDao.getList();
	}

}
