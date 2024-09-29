<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
        .center{
            text-align:center;
            margin-top: 50px;
        }
        .fon{
            font-size: 40px;
        }
        .fon1{
            font-size: 20px;
        }-
       body{
            background: url("images/login.jpg");
            background-size: 100% 100%;
        }
        input {
            background-color: transparent;
            outline: none;
            color: black;
        }
        .i{
        color: red;
        }

    </style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录界面</title>
</head>
<body>
<div class="center">
    <p class="fon">登录界面</p>
    <p>请输入您的用户名和密码进行注册</p>
  
        <form action="LoginServlet" method="post" class="i">
        <input type="radio" id="admin" name="role" value="admin"  >
        <label for="admin">管理员</label><br>
        <input type="radio" id="user" name="role" value="user" checked>
        <label for="user">普通用户</label><br>
        <input type="radio" id="doctor" name="role" value="doctor" >
        <label for="doctor">医生</label><br>
        <br>
        用户名: <input type="text" name="userName" required style="width: 300px;height: 50px;color: red;" placeholder="请输入用户名：" ><br>
        密码: <input type="password" name="pwdName" required style="width: 300px;height: 50px;color: red;" placeholder="请输入密码：" ><br>
       <a href="register.jsp">注册</a>&nbsp;&nbsp;&nbsp;&nbsp; <button type="submit" value="登录">登录</button>
    </form>
</div>

	
	
</body>
</html>