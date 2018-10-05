package com.jaehwan.web.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaehwan.web.dao.QuestionDao;
import com.jaehwan.web.entity.Question;

@Repository
public class HbQuestionDao implements QuestionDao {

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	@Transactional
	public int insert(Question question) {
		Session session = sessionFactory.getCurrentSession();
		
		Object id = session.save(question);
		
		if(id != null)
			return 1;
	
		return 0;
	}

	@Override
	@Transactional
	public int update(Question question) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(question);
		return 1;
	}

	@Override
	@Transactional
	public int delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Question question = new Question();
		question.setId(id);
		
		session.remove(question);
		
		return 1;
	}

	@Override
	@Transactional
	public Question get(long id) {
		Session session = sessionFactory.getCurrentSession();
		Question question = session.get(Question.class, id);
		
		return question;
	}

	@Override
	public List<Question> getList(String query, String ownerId, String sortField, int page) {
		// TODO Auto-generated method stub
		return null;
	}

}
