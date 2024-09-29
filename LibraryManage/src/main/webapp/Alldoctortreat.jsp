<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="service.AppointmentService, entity.Appointment, entity.Doctor_schedule,java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>所有医生坐诊时间安排</title>
        
    
</head>
<body>
<%
AppointmentService appointmentService = new AppointmentService();
    List<Doctor_schedule> appointmentList = appointmentService.getAlltreatList();
   
    request.setAttribute("appointmentList", appointmentList);
%>
    <h1>所有医生坐诊时间安排</h1>
    <h2><a href="loginSuccess.jsp">首页</a></h2>
    <table border="1">
        <tr>
            <th>预约编号</th>
           
            <th>医生id</th>
            <th>预约时间</th>
            <th>最大预约数量</th>
        </tr>
        <c:forEach var="appointment" items="${appointmentList}">
            <tr>
                <td width=100th>${appointment.id}</td>
              
                <td width=100th>${appointment.doctor_id}</td>
                <td width=100th>${appointment.schedule_time}</td>
                <td width=100th>${appointment.max_appointment}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>