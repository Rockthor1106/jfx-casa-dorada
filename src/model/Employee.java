package model;

import java.io.Serializable;

public class Employee extends Person implements Serializable {

	private static final long serialVersionUID = -3441966887631704526L;
	private String username;
	private String password;
	private String fullname; 

	public Employee(String name, String last_name, String id_number, String username, String password) {
		super(name, last_name, id_number);
		this.username = username;
		this.password = password;
		this.fullname = name + " " + last_name;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getFullName() {
		return fullname;
	}

    public int compareNameAndLastName(Employee employee) {
        return getFullName().compareToIgnoreCase(employee.getFullName());
    }
	

	public int compareNameAndLastName(String employee_fullname) {
        return getFullName().compareToIgnoreCase(employee_fullname);
    }

}
