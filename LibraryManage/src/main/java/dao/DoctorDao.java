package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Doctor;
import utils.DBUtils;

public class DoctorDao  {
	public Doctor login(String username) throws Exception {
		Connection connection = DBUtils.getConnection();		
		String sql = "SELECT * FROM doctor WHERE name = ? ";		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		ResultSet resultSet = statement.executeQuery();
		 Doctor doctor = null;		 
		 System.out.println("10");
		while (resultSet.next()) {
			System.out.println("2");
			doctor = new Doctor();
			doctor.setDoctor_id(resultSet.getInt("doctor_id"));
			doctor.setName(resultSet.getString("name"));
			doctor.setPassword(resultSet.getString("password"));
			doctor.setDepartment(resultSet.getString("department"));
			doctor.setTitle(resultSet.getString("title"));
			System.out.println(doctor);
		}		
		DBUtils.close(resultSet, statement, connection);
		return doctor;
	}
	public int register(Doctor doctor) throws SQLException{
		Connection connection = DBUtils.getConnection();
		String sql = "INSERT INTO doctor (name,password,department) VALUES (?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, doctor.getName());
		statement.setString(2, doctor.getPassword());
		statement.setString(3, doctor.getDepartment());
		int row = statement.executeUpdate();
		DBUtils.close(null, statement, connection);
		return row;
	}
}
