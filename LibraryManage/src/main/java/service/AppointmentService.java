package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import entity.Appointment;
import entity.Doctor;
import entity.Doctor_schedule;

public class AppointmentService extends HttpServlet  {
	 public List<Appointment> getAppointmentList() {
	        List<Appointment> appointments= new ArrayList<>();
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;	 
	        try {	          
	            Class.forName("com.mysql.cj.jdbc.Driver");	     
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chap3", "root", "root");	   
	            String sql = "SELECT * FROM appointment order by date";	           
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	            while (rs.next()) {
	            	Appointment appointment = new Appointment();
	            	appointment.setId(rs.getInt("id"));
	            	appointment.setUser_id(rs.getInt("user_id"));
	            	appointment.setDoctor_id(rs.getInt("doctor_id"));
	            	appointment.setDate(rs.getDate("date"));
	            	appointment.setStatus(rs.getString("status"));
	            	appointments.add(appointment);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
	            try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
	            try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	        }
	 
	        return appointments;
	    }
	 public List<Appointment> getpersonalAppointmentList(HttpSession session) {
	        List<Appointment> appointments= new ArrayList<>();
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	 
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");	         		
	            Integer  i=(Integer )session.getAttribute("myid");
	            System.out.println(i+"sss");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chap3", "root", "root");
	            String sql = "SELECT * FROM appointment where user_id="+i+" order by date";
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	            while (rs.next()) {
	            	Appointment appointment = new Appointment();
	            	appointment.setId(rs.getInt("id"));
	            	appointment.setUser_id(rs.getInt("user_id"));
	            	appointment.setDoctor_id(rs.getInt("doctor_id"));
	            	appointment.setDate(rs.getDate("date"));
	            	appointment.setStatus(rs.getString("status"));
	            	appointments.add(appointment);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
	            try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
	            try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	        }
	 
	        return appointments;
	    }
	 public List<Appointment> getDoctorAppointmentList(HttpSession session) {
	        List<Appointment> appointments= new ArrayList<>();
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	 
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	         
		
	            Integer  i=(Integer )session.getAttribute("myid");
	            System.out.println(i+"sss");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chap3", "root", "root");	         
	            String sql = "SELECT * FROM appointment where doctor_id="+i+" order by date";	          
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	            while (rs.next()) {
	            	Appointment appointment = new Appointment();
	            	appointment.setId(rs.getInt("id"));
	            	appointment.setUser_id(rs.getInt("user_id"));
	            	appointment.setDoctor_id(rs.getInt("doctor_id"));
	            	appointment.setDate(rs.getDate("date"));
	            	appointment.setStatus(rs.getString("status"));
	            	appointments.add(appointment);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
	            try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
	            try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	        }
	 
	        return appointments;
	    }
	 public List<Doctor_schedule> getPersonalDoctorList(HttpSession session) {
	        List<Doctor_schedule> appointments= new ArrayList<>();
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	 
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");	         		
	            Integer  i=(Integer )session.getAttribute("myid");
	            System.out.println("myid="+i);
	            System.out.println(i+"sss");    
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chap3", "root", "root");	   
	            String sql = "SELECT * FROM doctor_schedule where doctor_id="+i+" order by schedule_time";
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	            while (rs.next()) {
	            	Doctor_schedule appointment = new Doctor_schedule();
	            	appointment.setId(rs.getInt("id"));
	            	appointment.setDoctor_id(rs.getInt("doctor_id"));
	            	appointment.setSchedule_time(rs.getDate("schedule_time"));
	            	appointment.setMax_appointment(rs.getInt("max_appointments"));
	            	appointments.add(appointment);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
	            try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
	            try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	        }
	 
	        return appointments;
	    }
	 public List<Doctor_schedule> getAlltreatList() {
	        List<Doctor_schedule> appointments= new ArrayList<>();
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	 
	        try {	       
	            Class.forName("com.mysql.cj.jdbc.Driver");	         			                    	                  
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chap3", "root", "root");
	            String sql = "SELECT * FROM doctor_schedule order by schedule_time ";
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	            while (rs.next()) {
	            	Doctor_schedule appointment = new Doctor_schedule();
	            	appointment.setId(rs.getInt("id"));
	            	appointment.setDoctor_id(rs.getInt("doctor_id"));
	            	appointment.setSchedule_time(rs.getDate("schedule_time"));
	            	appointment.setMax_appointment(rs.getInt("max_appointments"));
	            	appointments.add(appointment);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
	            try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
	            try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	        }
	 
	        return appointments;
	    }
	 public void undo(int appid) {
	        List<Appointment> appointments= new ArrayList<>();
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;	 
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chap3", "root", "root");	            
	            String sql = "delete  from appointment where `id`="+appid;	          
	            pstmt = conn.prepareStatement(sql);	      
	          int r=pstmt.executeUpdate();
	          System.out.println(r + " rows deleted.");	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
	            try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
	            try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	        }	 	        
	    }
	 public void doctorundo(int appid) {
	        List<Appointment> appointments= new ArrayList<>();
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;	 
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");	      
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chap3", "root", "root");	            
	            String sql = "delete  from doctor_schedule where `id`="+appid;	       
	            pstmt = conn.prepareStatement(sql);
	          int r=pstmt.executeUpdate();
	          System.out.println(r + " rows deleted.");	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
	            try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
	            try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	        }	 	        
	    }
	 public void deletedoctor(int appid) {
	        List<Appointment> appointments= new ArrayList<>();
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;	 
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chap3", "root", "root");	            
	            String sql = "delete  from doctor where `doctor_id`="+appid;	       
	            pstmt = conn.prepareStatement(sql);
	          int r=pstmt.executeUpdate();
	          System.out.println(r + " rows deleted.");            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
	            try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
	            try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	        }
	 
	        
	    }

}
