<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加医生账号界面</title>
</head>
<body>
<h1>添加医生账号</h1>
<h2><a href="loginSuccessa.jsp">首页</a></h2>
	<form action="AdddoctorServlet" method="post" accept-charset="UTF-8">
		医生姓名：<input type="text" id="id" name="id" placeholder="输入医生姓名" /><br>
		医生部门：<input type="text" id="department" name="department" placeholder="输入医生部门" /><br>		
		医生密码：<input type="password" id="pwd1" name="pwd1" placeholder="输入密码" /><br>
		确认密码：<input type="password" id="pwd2" name="pwd2" placeholder="再次输入密码" /><br>
		<button type="submit">注册</button>
	</form>
</body>
</html>