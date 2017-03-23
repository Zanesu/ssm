package com.txy.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.txy.shiro.ShiroUser;

public class ShiroUtil {
	public static ShiroUser getShiroUser() {
		Subject subject = getSubject();
		ShiroUser shiroUser = (ShiroUser) subject.getPrincipal();
		return shiroUser;
	}

	private static Subject getSubject() {
		// TODO Auto-generated method stub
		return SecurityUtils.getSubject();
	}
}
