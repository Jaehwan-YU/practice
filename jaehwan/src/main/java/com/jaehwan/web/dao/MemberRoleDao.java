package com.jaehwan.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jaehwan.web.entity.MemberRole;

public interface MemberRoleDao {
	
	int insert(MemberRole memberRole);
	int update(MemberRole memberRole);
	int delete(MemberRole memberRole);
	
	List<MemberRole> getList(String memberId);
	List<MemberRole> getList();
	
}
