<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="service.DoctorService1, entity.Doctor, entity.Doctor_schedule,service.AppointmentService, java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>患者搜索</title>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.12.4.js"></script>
    <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
        $(function() {
            $("#datepicker").datepicker({
                changeMonth: true,
                changeYear: true,
                dateFormat: 'yy-mm-dd',
                yearRange: '-100:+100'
              });
        });
    </script>
</head>
<body>
<h1>搜索医生</h1>
<h2><a href=loginSuccess.jsp>首页</a></h2>
<form action="SearchServlet" method="post">
    <label for="department">按科室:</label>
    <input type="text" id="department" name="department" /> <br>  
    <label for="doctor">按医生姓名:</label>
    <input type="text" id="doctor" name="doctor" /><br>
        <label for="title">按医生职称:</label>
    <select id="title" name="title">
        <option value="普通医生">普通医生</option>
        <option value="专家">专家</option>
    </select><br>
    <label for="date">按坐诊日期:</label>
    <input type="date" name="date" id="datepicker" /><br/>
    <br>
    <input type="submit" value="搜索" /><br>
     
</form>
</body>
</html>