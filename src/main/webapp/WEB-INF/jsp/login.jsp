<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/jsp/common/include.inc.jsp"%>
<title>登录页面</title>
</head>
<body>
	<form action="${txy}/login/login">
		用户名：<input type="text" name="name"><br /> 密码：<input
			type="password" name="password"><br /> <input type="submit">
	</form>
</body>
</html>