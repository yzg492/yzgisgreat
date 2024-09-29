package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;
import utils.DBUtils;

/**
 * 用户数据库的处理
 */
public class UserDao {
	public User login(String username) throws Exception {
		Connection connection = DBUtils.getConnection();
		String sql = "SELECT * FROM user WHERE username = ? ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		ResultSet resultSet = statement.executeQuery();
		User user = null;
		while (resultSet.next()) {
			user = new User();
			user.setId(resultSet.getInt("user_id"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			System.out.println(user);
		}
		DBUtils.close(resultSet, statement, connection);
		return user;
	}
	public int register(User user) throws SQLException{
		Connection connection = DBUtils.getConnection();
		String sql = "INSERT INTO user (username,password) VALUES (?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getUsername());
		statement.setString(2, user.getPassword());
		int row = statement.executeUpdate();
		DBUtils.close(null, statement, connection);
		return row;
	}

}