package com.jaehwan.web.dao;

import java.util.List;

import com.jaehwan.web.entity.MemberRole;

public interface MemberRoleDao {
	
	int insert(MemberRole memberRole);
	int update(MemberRole memberRole);
	int delete(MemberRole memberRole);
	
	List<MemberRole> get(String memberId);
	List<MemberRole> getList();
	
}
