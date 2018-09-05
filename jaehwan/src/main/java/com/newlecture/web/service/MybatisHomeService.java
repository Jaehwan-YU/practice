package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaehwan.web.dao.MemberRoleDao;
import com.jaehwan.web.entity.MemberRole;

@Service
public class MybatisHomeService implements HomeService{
	
	@Autowired
	private MemberRoleDao memberRoleDao;

	@Override
	public String getDefaultRoleName(String memberId) {
		
		List<MemberRole> memberRoles = memberRoleDao.getList(memberId);
		
		String defaultRoleName = "ROLE_STUDENT";
		
		for(MemberRole roleName : memberRoles) {
			if(roleName.getDefaultRole()) 
				defaultRoleName = roleName.getRoleName();
		}
		
		return defaultRoleName;
	} 
	
}
