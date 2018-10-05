package com.jaehwan.web.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaehwan.web.dao.SubjectDao;
import com.jaehwan.web.entity.Subject;

@Repository
public class HbSubjectDao implements SubjectDao {

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	@Transactional
	public int insert(Subject subject) {
		Session session = sessionFactory.getCurrentSession();
		
		Object id = session.save(subject);
		
		if(id != null)
				return 1;
		
		return 0;	
		}

	@Override
	@Transactional
	public int update(Subject subject) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.update(subject);
		
		return 1;
	}

	@Override
	@Transactional
	public int delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Subject subject = new Subject();
		subject.setId(id);
		
		session.remove(subject);
		return 1;
	}

	@Override
	@Transactional
	public Subject get(long id) {
		Session session = sessionFactory.getCurrentSession();
		Subject subject = session.get(Subject.class, id);
		return subject;
	}

	@Override
	public List<Subject> getList() {
		Session session = sessionFactory.getCurrentSession();	
			
		return null;
	}

}
