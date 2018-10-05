package com.jaehwan.web.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaehwan.web.dao.MemberRoleDao;
import com.jaehwan.web.entity.MemberRole;

@Repository
public class HbMemberRoleDao implements MemberRoleDao {

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	@Transactional
	public int insert(MemberRole memberRole) {
		Session session = sessionFactory.getCurrentSession();
		
		Object id = session.save(memberRole);
		
		if(id != null)
			return 1;
	
		return 0;
	}

	@Override
	@Transactional
	public int update(MemberRole memberRole) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(memberRole);
		
		return 1;
	}

	@Override
	@Transactional
	public int delete(MemberRole memberRole) {
		Session session = sessionFactory.getCurrentSession();
		session.remove(memberRole);
		
		return 1;
	}

	@Override
	public List<MemberRole> getList(String memberId) {	
		
		return null;
	}

	@Override
	public List<MemberRole> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
