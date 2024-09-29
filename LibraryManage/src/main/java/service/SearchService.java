package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entity.Appointment;
import entity.Doctor;
import entity.Doctor_schedule;

public class SearchService {
    public static Map.Entry<List<Doctor>, List<Doctor_schedule>> getLists(String name,String department,String date,String title) {
      List<Doctor> doctors = new ArrayList<>();
      List<Doctor_schedule> appointments= new ArrayList<>();
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
          Class.forName("com.mysql.cj.jdbc.Driver");        
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chap3", "root", "root");
          String sql = "SELECT * FROM doctor a,doctor_schedule b where 1=1  and a.doctor_id=b.doctor_id ";
         
          if(department != null && !department.isEmpty()) {
        	    sql += " AND a.department = '" + department + "'";
        	    System.out.println("depart="+department);
        	}
          if(name != null && !name.isEmpty()) {
        	    sql += " AND a.name = '" + name + "'  AND a.doctor_id=b.doctor_id ";
        	}
        	if(title != null && !title.isEmpty()) {
        	    sql += " AND a.title = '" + title + "'";
        	}      	
        	if(date != null && !date.isEmpty()) {
        		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            	 java.util.Date da = formatter.parse(date);
                 Date sqlDate = new Date(da.getTime());
        	    sql += " AND b.schedule_time = '" + sqlDate + "'";
        	}
        	 pstmt = conn.prepareStatement(sql);
             rs = pstmt.executeQuery();
        	 System.out.println(sql);
          while (rs.next()) {
              Doctor doctor = new Doctor();
             Doctor_schedule a=new   Doctor_schedule();
              doctor.setDoctor_id(rs.getInt("doctor_id"));
              doctor.setName(rs.getString("name"));
              doctor.setDepartment(rs.getString("department"));
              doctor.setTitle(rs.getString("title"));
            a.setSchedule_time(rs.getDate("schedule_time"));
            a.setMax_appointment(rs.getInt("max_appointments"));
            System.out.println(doctor);
            System.out.println(a);
              doctors.add(doctor);
              appointments.add(a);
          }
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
          try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
          try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
      }
        return new AbstractMap.SimpleEntry<>(doctors, appointments);
    }

}
