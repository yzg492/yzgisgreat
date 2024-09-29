<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="service.AppointmentService, entity.Appointment, java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <script type="text/javascript">
        function undo(id) {
            
            var xhr = new XMLHttpRequest();
            xhr.open('GET', 'AppointmentServlet?id=' +id, true);
            xhr.onload = function() {
                if (this.status == 200) {
                    // 请求成功，这里可以处理响应数据
                  //  在JSP页面中，你可以使用JavaScript来触发一个Ajax请求，该请求会向后端的service发送一个HTTP GET或POST请求，并且可以传递一个参数。
                    console.log(this.responseText);
                }
            };
            xhr.send();
           
        }
    </script>
<title>我的坐诊安排</title>
</head>
<body>
<%
AppointmentService doctorappointmentService = new AppointmentService();

    List<Appointment> appointmentList = doctorappointmentService.getDoctorAppointmentList(session);
   
    request.setAttribute("appointmentList", appointmentList);
%>
    <h1>我的门诊预约列表</h1>
    <h2><a href="loginSuccessd.jsp">首页</a></h2>
    <table border="1">
        <tr>
            <th>预约编号</th>
            <th>患者id</th>
            <th>医生id</th>
            <th>预约时间</th>
            <th>预约状态</th>
            <th>是否撤销该预约</th>
        </tr>
        <c:forEach var="appointment" items="${appointmentList}">
            <tr>
                <td width=100th>${appointment.id}</td>
                <td width=100th>${appointment.user_id}</td>
                <td width=100th>${appointment.doctor_id}</td>
                <td width=100th>${appointment.date}</td>
                <td width=100th>${appointment.status}</td>
      <td width=100th> <input type="button" id="undoButton" value="撤销" onclick="undo(${appointment.id})" /></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>