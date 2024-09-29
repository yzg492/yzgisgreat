<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="service.AppointmentService, entity.Appointment, java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>医疗预约列表</title>
        
    
</head>
<body>
<%
AppointmentService appointmentService = new AppointmentService();
    List<Appointment> appointmentList = appointmentService.getAppointmentList();
   
    request.setAttribute("appointmentList", appointmentList);
%>
    <h1>门诊预约列表</h1>
    <h2><a href="loginSuccessd.jsp">首页</a></h2>
    <table border="1">
        <tr>
            <th>预约编号</th>
            <th>患者id</th>
            <th>医生id</th>
            <th>预约时间</th>
            <th>预约状态</th>
        </tr>
        <c:forEach var="appointment" items="${appointmentList}">
            <tr>
                <td width=100th>${appointment.id}</td>
                <td width=100th>${appointment.user_id}</td>
                <td width=100th>${appointment.doctor_id}</td>
                <td width=100th>${appointment.date}</td>
                <td width=100th>${appointment.status}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>