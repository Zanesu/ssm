package com.txy.shiro;

import java.io.Serializable;

import com.txy.model.User;

public class ShiroUser implements Serializable {
	private String name;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ShiroUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShiroUser(User user) {
		super();
		this.name = user.getUserName();
		this.id = user.getUserId() + "";
	}

	public ShiroUser(String username) {
		super();
		this.name = username;
	}

}
