package entity;

import java.sql.Date;

public class Doctor_schedule {
	private int id;
	private int doctor_id;
	private int department_id;
	private String title;
	private Date   schedule_time;
	private int max_appointment;
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getTitle() {
		return title;
	}
	
	public Date getSchedule_time() {
		return schedule_time;
	}
	public void setSchedule_time(Date schedule_time) {
		this.schedule_time = schedule_time;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMax_appointment() {
		return max_appointment;
	}
	public void setMax_appointment(int max_appointment) {
		this.max_appointment = max_appointment;
	}
	@Override
	public String toString() {
		return "Doctor_schedule [doctor_id=" + doctor_id + ", department_id=" + department_id + ", title=" + title
				+ ", max_appointment=" + max_appointment + "]";
	}

}
