<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="service.AppointmentService, entity.Appointment,entity.Doctor_schedule, java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <script type="text/javascript">
        function doctorundo(id) {
            
            var xhr = new XMLHttpRequest();
            xhr.open('GET', 'DoctorsetServlet?id=' +id, true);
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
<title>我的门诊时间列表</title>
</head>
<body>
<%
AppointmentService doctorappointmentService = new AppointmentService();

    List<Doctor_schedule> appointmentList = doctorappointmentService.getPersonalDoctorList(session);
   
    request.setAttribute("appointmentList", appointmentList);
%>
    <h1>个人门诊时间列表</h1>
    <h2><a href="loginSuccessd.jsp">首页</a></h2>
    <table border="1">
        <tr>
           
            <th>我的id</th>
            <th>坐诊时间</th>
            <th width=200th>当日最大可预约人数</th>
            <th width=180th>是否撤销该日门诊安排</th>
        </tr>
        <c:forEach var="appointment" items="${appointmentList}">
            <tr>
                
                <td width=100th>${appointment.doctor_id}</td>
                <td width=100th>${appointment.schedule_time}</td>
                <td width=100th>${appointment.max_appointment}</td>
                <td width=100th> <input type="button" id="undoButton" value="撤销" onclick="doctorundo(${appointment.id})" /></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>