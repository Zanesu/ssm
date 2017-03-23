package com.txy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.txy.model.Role;
import com.txy.model.RoleKey;

public interface RoleMapper {
	int deleteByPrimaryKey(RoleKey key);

	int insert(Role record);

	int insertSelective(Role record);

	Role selectByPrimaryKey(RoleKey key);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

	List<Role> getRoleByUid(@Param("uid") String uid);
}