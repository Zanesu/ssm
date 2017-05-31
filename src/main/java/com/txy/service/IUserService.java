package com.txy.service;

import java.util.List;

import com.txy.model.Role;
import com.txy.model.User;

public interface IUserService {
	public User getUserById(int userId);

	public User getByUsername(String name);

	void save(User user);
	
	void scaduleTest();

	/**
	 * 根据用户id获取该用户的权限
	 * 
	 * @param id
	 * @return
	 */
	List<Role> getRoles(String id);
}