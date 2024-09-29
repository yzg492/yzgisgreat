<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="service.DoctorService1, entity.Doctor, java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>医生列表</title>
</head>
<body>
    <h1>医生列表</h1>
    <h2><a href="loginSuccess.jsp">首页</a></h2>
    <table border="1">
        <tr>
            <th width=100th>ID</th>
            <th width=100th>姓名</th>
            <th width=100th>部门</th>
        </tr>
        <%
    DoctorService1 doctorService1 = new DoctorService1();
    List<Doctor> doctorList = doctorService1.getDoctorList();
    request.setAttribute("doctorList", doctorList);
%>
        <c:forEach var="doctor" items="${doctorList}">
            <tr>
             <td>${doctor.doctor_id}</td>
                <td>${doctor.name}</td>
                <td>${doctor.department}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
 
