package com.jaehwan.web.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaehwan.web.dao.MemberDao;
import com.jaehwan.web.entity.Member;

@Repository
public class HbMemberDao implements MemberDao {

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	@Transactional
	public int insert(Member member) {
		Session session = sessionFactory.getCurrentSession();
		
		Object id = session.save(member);
		
		if(id != null)
				return 1;
		
		return 0;
	}

	@Override
	@Transactional
	public int update(Member member) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.update(member);
		
		return 1;
	}

	@Override
	@Transactional
	public int delete(String id) {
		
		Session session = sessionFactory.getCurrentSession();
		Member member = new Member();
		member.setId(id);
		
		session.remove(member);
		
		
		return 1;
	}

	@Override
	@Transactional
	public Member get(String id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Member member = session.get(Member.class, id);
		
		return member;
	}

	@Override
	public Member getByEmail(String email) {
		
		return null;
	}

	@Override
	public List<Member> getList() {
		
		return null;
	}

	@Override
	public List<Member> getList(int page) {
		
		return null;
	}

	@Override
	public List<Member> getList(String field, String query) {
		
		return null;
	}

	@Override
	public List<Member> getList(String field, String query, int page) {
		
		return null;
	}


}
