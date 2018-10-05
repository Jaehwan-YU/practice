package com.jaehwan.web.dao;

import com.jaehwan.web.entity.Academy;

public interface AcademyDao {
	
	int insert(Academy academy);
	int update(Academy academy);
	int delete(int id);
	Academy get(int id);
	
}
