package com.jaehwan.web.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaehwan.web.dao.QuestionLevelDao;
import com.jaehwan.web.entity.QuestionLevel;

@Repository
public class HbQuestionLevelDao implements QuestionLevelDao {

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	@Transactional
	public int insert(QuestionLevel level) {
		Session session = sessionFactory.getCurrentSession();
		
		Object id = session.save(level);
		
		if(id != null)
				return 1;
		
		return 0;
	}

	@Override
	@Transactional
	public int update(QuestionLevel level) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(level);
		
		return 1;
	}

	@Override
	@Transactional
	public int delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		
		QuestionLevel questionLevel = new QuestionLevel();
		questionLevel.setId(id);
		
		session.remove(questionLevel);
		
		return 1;
	}

	@Override
	@Transactional
	public QuestionLevel get(long id) {
		Session session = sessionFactory.getCurrentSession();
		
		QuestionLevel questionLevel = session.get(QuestionLevel.class, id);
		return questionLevel;
	}

	@Override
	public List<QuestionLevel> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
