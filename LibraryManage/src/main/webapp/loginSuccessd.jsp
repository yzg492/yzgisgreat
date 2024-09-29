<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>医院门诊预约系统首页</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="font-sans">
<%
    String user = (String) session.getAttribute("user");
%>
<header class="bg-gradient-to-r from-blue-400 to-blue-600 p-4 text-center text-white shadow-lg">
    <h1 class="text-4xl font-bold animate__animated animate__fadeInDown">欢迎<%= user %>医生来到阳光医院门诊</h1>
    <p class="my-2">当前日期和时间: <span id="dateTime"></span></p>
     <p> <a href="index.jsp">切换账号</a></p>
    <nav>
        <ul class="flex justify-center list-none p-0 m-0">
            <li class="mr-4"><a href="loginSuccessd.jsp">预约首页</a></li>
            <li class="mr-4"><a href="settreat.jsp">个人坐诊设置</a></li>
            <li class="mr-4"><a href="personaltreat.jsp">个人坐诊列表</a></li>    
             <li class="mr-4"><a href="appointmentd.jsp">全部预约列表</a></li>     
            <li class="mr-4"><a href="mytreat.jsp">我的预约列表</a></li>
              <li><a href="changepasswordd.jsp">更改密码</a></li>
        </ul>
    </nav>
</header>
</body>
</html>
<script>
    document.getElementById('dateTime').textContent = new Date().toLocaleString();
</script>