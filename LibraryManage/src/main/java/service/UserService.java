package service;

import java.sql.SQLException;

import dao.UserDao;
import entity.User;

/**
 * 业务层处理
 * */
public class UserService {
	private UserDao userDao = new UserDao();
	public User login(String username, String password) {
		User user = null;
		try {
			user = userDao.login(username);
			
			if (!user.getPassword().equals(password)) {
				System.out.println("密码不对");
				user = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public int register(User user) {		
		int row = 0;
		try {
			row = userDao.register(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return row;
	}

}