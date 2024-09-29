package entity;

public class Admin {
private int id;
	public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
	private String name;
	private String password;
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
		return "Admin [name=" + name + ", password=" + password + "]";
	}
	
}
