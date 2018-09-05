package com.jaehwan.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaehwan.web.dao.MemberRoleDao;
import com.jaehwan.web.entity.MemberRole;

@Repository
public class MybatisMemberRoleDao implements MemberRoleDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(MemberRole memberRole) {
		MemberRoleDao memberRoleDao = sqlSession.getMapper(MemberRoleDao.class);
		return memberRoleDao.insert(memberRole);
	}

	@Override
	public int update(MemberRole memberRole) {
		MemberRoleDao memberRoleDao = sqlSession.getMapper(MemberRoleDao.class);
		return memberRoleDao.update(memberRole);
	}

	@Override
	public int delete(MemberRole memberRole) {
		MemberRoleDao memberRoleDao = sqlSession.getMapper(MemberRoleDao.class);
		return memberRoleDao.delete(memberRole);
	}

	@Override
	public List<MemberRole> get(String memberId) {
		MemberRoleDao memberRoleDao = sqlSession.getMapper(MemberRoleDao.class);
		return memberRoleDao.get(memberId);
	}

	@Override
	public List<MemberRole> getList() {
		MemberRoleDao memberRoleDao = sqlSession.getMapper(MemberRoleDao.class);
		return memberRoleDao.getList();
	}

}
