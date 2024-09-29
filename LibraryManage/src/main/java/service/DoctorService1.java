package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Doctor;
 
public class DoctorService1 {
 
    public List<Doctor> getDoctorList() {
        List<Doctor> doctors = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chap3", "root", "root");
            String sql = "SELECT * FROM doctor";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setDoctor_id(rs.getInt("doctor_id"));
                doctor.setName(rs.getString("name"));
                doctor.setDepartment(rs.getString("department"));
                doctor.setTitle(rs.getString("title"));
                doctors.add(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
 
        return doctors;
    }
}