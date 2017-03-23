package com.txy.dao;

import com.txy.model.User;

public interface IUserDao {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(String id);

	User selectByUsername(String name);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}