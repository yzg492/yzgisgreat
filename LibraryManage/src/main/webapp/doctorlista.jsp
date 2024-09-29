<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="service.DoctorService1, entity.Doctor,entity.Appointment, java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="service.AppointmentService, entity.Doctor_schedule, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>医生列表</title>
     <script type="text/javascript">
        function deletedoctor(id) {
            
            var xhr = new XMLHttpRequest();
            xhr.open('GET', 'DeletedoctorServlet?id=' +id, true);
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
<%
AppointmentService appointmentService = new AppointmentService();
    List<Doctor_schedule> appointmentList = appointmentService.getAlltreatList();
   
    request.setAttribute("appointmentList", appointmentList);
%>
</head>
<body>
    <h1>医生列表</h1>
    <h2><a href="loginSuccessa.jsp">首页</a></h2>
    <table border="1">
        <tr>
            <th width=100th>ID</th>
            <th width=100th>姓名</th>
            <th width=100th>部门</th>
              <th>是否删除该医生账号</th>
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
                  <td width=100th> <input type="button" id="undoButton" value="删除" onclick="deletedoctor(${doctor.doctor_id})" /></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
 
