package com.jaehwan.web.dao;

import java.util.List;

import com.jaehwan.web.entity.Level;

public interface LevelDao {
	
	int insert(Level level);
	int update(Level level);
	int delete(long id);
	
	Level get(long id);
	List<Level> getList();
}
