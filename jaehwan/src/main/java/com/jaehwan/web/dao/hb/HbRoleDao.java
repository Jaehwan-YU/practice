package com.jaehwan.web.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaehwan.web.dao.RoleDao;
import com.jaehwan.web.entity.Member;
import com.jaehwan.web.entity.Role;

@Repository
public class HbRoleDao implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	@Transactional
	public int insert(Role role) {
		Session session = sessionFactory.getCurrentSession();
		
		Object id = session.save(role);
		
		if(id != null)
				return 1;
		
		return 0;
	}

	@Override
	@Transactional
	public int update(Role role) {
		Session session = sessionFactory.getCurrentSession();
		session.update(role);
		return 1;
	}

	@Override
	@Transactional
	public int delete(String name) {
		Session session = sessionFactory.getCurrentSession();
		
		Role role =  new Role();
		role.setName(name);
		
		session.remove(role);
		return 1;
	}

	@Override
	@Transactional
	public Role get(String name) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Role role = session.get(Role.class, name);
		
		return role;
	}

	@Override
	public List<Role> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
