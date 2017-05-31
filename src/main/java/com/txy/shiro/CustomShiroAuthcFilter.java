package com.txy.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.AccessControlFilter;

import com.txy.util.ShiroUtil;

public class CustomShiroAuthcFilter extends AccessControlFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest arg0, ServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		String header = ((HttpServletRequest) arg0).getHeader("X-Requested-With");
		if (ShiroUtil.getShiroUser() != null) {
			return true;
		} else {
			if ("XMLHttpRequest".equalsIgnoreCase(header)) {
				// ajax判断是否登陆，并可返回json
				arg1.setCharacterEncoding("utf-8");
				arg1.getWriter().write("用户登录失效，重新登录");
			}

		}
		return false;

	}

	@Override
	protected boolean onAccessDenied(ServletRequest arg0, ServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
