package com.newlecture.web.service;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaehwan.web.dao.MemberDao;
import com.jaehwan.web.dao.MemberRoleDao;
import com.jaehwan.web.entity.Member;
import com.jaehwan.web.entity.MemberRole;

@Service
public class MybatisHomeService{
	
	@Autowired
	private MemberRoleDao memberRoleDao;
	@Autowired
	private MemberDao memberDao;
	
	public String getDefaultRoleName(String memberId) {
		
		List<MemberRole> memberRoles = memberRoleDao.getList(memberId);
		
		String defaultRoleName = "ROLE_STUDENT";
		
		for(MemberRole roleName : memberRoles) {
			if(roleName.getDefaultRole()) 
				defaultRoleName = roleName.getRoleName();
		}
		
		return defaultRoleName;
	}

	public boolean isEmailDuplicated(String email) {
		
		Member member = memberDao.getByEmail(email);
		
		if(member != null)
			return true;
		
		return false;
	}
	
	public boolean isIdDuplicated(String id) {
		
		Member member = memberDao.get(id);
		
		if(member != null)
			return true;
		
		return false;
		
	}

	public int insertMember(Member member) {
		
		int result = memberDao.insert(member);
		memberRoleDao.insert(new MemberRole(member.getId(), "ROLE_STUDENT" , true));
		
		return result;
	}
	
	
}
