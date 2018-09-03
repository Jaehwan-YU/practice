package com.jaehwan.web.dao;

import java.util.List;

import com.jaehwan.web.entity.MemberRole;

public interface MemberRoleDao {
	
	int insert(MemberRole memberRole);
	int update(MemberRole memberRole);
	int delete(String id);
	
	MemberRole get(String id);
	List<MemberRole> getList();
	
}
