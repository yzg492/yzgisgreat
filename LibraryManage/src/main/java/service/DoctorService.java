package service;

import java.sql.SQLException;

import dao.DoctorDao;
import entity.Doctor;

public class DoctorService {
     private DoctorDao doctorDao =new DoctorDao();
		
	public  Doctor login(String username, String password) {	
		 Doctor doctor = null;
		try {					
			doctor=doctorDao.login(username);						
			if (! doctor.getPassword().equals(password)) {			
				System.out.println("密码不对");
				 doctor = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  doctor;
	}
	public int register(Doctor doctor) {
		int row = 0;
		try {
			row = doctorDao.register(doctor);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return row;
	}

}
