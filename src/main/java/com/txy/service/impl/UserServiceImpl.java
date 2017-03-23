package com.txy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.txy.dao.IUserDao;
import com.txy.dao.RoleMapper;
import com.txy.model.Role;
import com.txy.model.User;
import com.txy.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	@Resource
	private RoleMapper roleDao;

	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}

	@Override
	public List<Role> getRoles(String id) {
		// TODO Auto-generated method stub
		return roleDao.getRoleByUid(id);
	}

	@Override
	public User getByUsername(String name) {
		// TODO Auto-generated method stub
		return userDao.selectByUsername(name);
	}

}
