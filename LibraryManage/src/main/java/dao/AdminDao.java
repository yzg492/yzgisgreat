package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Admin;
import utils.DBUtils;

public class AdminDao {
	public Admin login(String username) throws Exception {
		Connection connection = DBUtils.getConnection();	
		String sql = "SELECT * FROM admin WHERE name = ? ";	
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, username);		
		ResultSet resultSet = statement.executeQuery();
		 Admin admin = null;		 			
		while (resultSet.next()) {		
			admin = new Admin();
			admin.setName(resultSet.getString("name"));
			admin.setPassword(resultSet.getString("password"));
			System.out.println(admin);
		}
		DBUtils.close(resultSet, statement, connection);
		return admin;
	}
	public int register(Admin admin) throws SQLException{
		Connection connection = DBUtils.getConnection();
		String sql = "INSERT INTO admin (name,password) VALUES (?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, admin.getName());
		statement.setString(2, admin.getPassword());	
		int row = statement.executeUpdate();
		DBUtils.close(null, statement, connection);
		return row;
	}
}
