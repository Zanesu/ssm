package com.txy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.txy.dao.RoleMapper;
import com.txy.dao.UserMapper;
import com.txy.model.Role;
import com.txy.model.User;
import com.txy.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userDao;
	@Resource
	private RoleMapper roleDao;

	public User getUserById(int userId) {
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

	@Scheduled(cron = "0/5 * *  * * ? ")
	public void scaduleTest() {
		User user = userDao.selectByPrimaryKey(1);
		System.out.println(user.getUserName());
	}

}
