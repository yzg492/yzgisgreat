package service;

import java.sql.SQLException;

import dao.AdminDao;

import entity.Admin;

public class AdminService {
private AdminDao adminDao =new AdminDao();
	public  Admin login(String username, String password) {
		Admin admin = null;
		try {			
			admin=adminDao.login(username);						
			if (! admin.getPassword().equals(password)) {			
				System.out.println("密码不对");
				 admin = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  admin;
	}
	public int register(Admin admin) {
		int row = 0;
		try {
			row = adminDao.register(admin);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return row;
	}
}
