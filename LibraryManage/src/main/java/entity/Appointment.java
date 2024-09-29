package entity;

import java.sql.Date;

public class Appointment {
    private int id;
    private int user_id;
    private int doctor_id;
    private Date date;
    private String status;
	public int getId() {
		return id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", user_id=" + user_id + ", doctor_id=" + doctor_id + ", date=" + date + "]";
	}
   
 
}