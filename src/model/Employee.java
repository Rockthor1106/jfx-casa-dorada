package model;

public class Employee extends Person {

	private String username;
	private String password;

	public Employee(String name, String last_name, String id_number, String username, String password) {
		super(name, last_name, id_number);
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
