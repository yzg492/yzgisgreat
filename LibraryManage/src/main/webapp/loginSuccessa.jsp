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
    <h1 class="text-4xl font-bold animate__animated animate__fadeInDown">欢迎<%= user %>管理员来到阳光医院门诊</h1>
    <p class="my-2">当前日期和时间: <span id="dateTime"></span></p>
     <p> <a href="index.jsp">切换账号</a></p>
    <nav>
        <ul class="flex justify-center list-none p-0 m-0">
            <li class="mr-3"><a href="loginSuccessa.jsp">预约首页</a></li>
            <li class="mr-3"><a href="doctorlista.jsp">所有医生列表</a></li>
          
             <li class="mr-3"><a href="adddoctor.jsp">添加医生账号</a></li>
        </ul>
    </nav>
</header>
</body>
</html>
<script>
    document.getElementById('dateTime').textContent = new Date().toLocaleString();
</script>