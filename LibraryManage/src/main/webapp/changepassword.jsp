<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>修改密码</title>
<% 
int id=(int)session.getAttribute("myid");
System.out.println(id);
//患者
%>
</head>
<body>
<h2>修改密码</h2>
<h3><a href="loginSuccess.jsp">首页</a></h3>
<form action="Changerpasswordd?id=<%=id%>" method="post">
    <label for="currentPassword">当前密码:</label>
    <input type="password" id="currentPassword" name="currentPassword" required><br><br>
 
    <label for="newPassword">新密码:</label>
    <input type="password" id="newPassword" name="newPassword" required><br><br>
 
    <label for="confirmNewPassword">确认新密码:</label>
    <input type="password" id="confirmNewPassword" name="confirmNewPassword" required><br><br>
 
    <input type="submit" value="提交">
</form>
</body>
</html>