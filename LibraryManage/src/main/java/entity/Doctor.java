package entity;

public class Doctor {
	private int id;
	private int doctor_id;
	private String name;
	private String password;
	private String department;
	private String title="待定";
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
public String getName() {
	return name;
	
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Doctor [doctor_id=" + doctor_id + ", name=" + name + ", password=" + password + ", department=" + department
			+ "]";
}

}
