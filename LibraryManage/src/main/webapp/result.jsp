<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="service.DoctorService1, entity.Doctor, entity.Doctor_schedule,service.AppointmentService, java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>搜索结果</title>
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
<h1>搜索结果</h1>
<h2 class=r-2><a href=loginSuccess.jsp>首页</a></h2><h2  class=r-2><a href=search.jsp>重新搜索</a></h2>
  <table border="1">
        <tr>
            <th width=100th>ID</th>
            <th width=100th>姓名</th>
            <th width=100th>部门</th>
             <th width=100th>职称</th>
              <th width=100th>可预约时间</th>
               <th width=100th>最大数量</th>
        </tr>
     <c:set var="list1" value="${requestScope.doctorList}" />
<c:set var="list2" value="${requestScope.appointmentList}" />
 
   <c:forEach var="item1" items="${list1}" varStatus="status">
    <tr>
      <td>${item1.doctor_id}</td>
       <td>${item1.name}</td>
        <td>${item1.department}</td>
         <td>${item1.title}</td>
      <td>${list2[status.index].schedule_time}</td>
      <td>${list2[status.index].max_appointment}</td>  <!-- 使用varStatus.index访问第二个列表的元素 -->
    </tr>
  </c:forEach>
        
    </table>
</body>
</html>