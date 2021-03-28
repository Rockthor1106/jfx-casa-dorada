package model;

import java.util.ArrayList;
import java.util.List;

public class UserAccounts {

	private List<Employee> employees;

	public UserAccounts() {
		employees = new ArrayList<>();
	}

	public void addEmployee(String name, String last_name, int id_number, String username, String password) {
		employees.add(new Employee(name, last_name, id_number, username, password));
	}

	public List<Employee> getUserAccounts() {
		return employees;
	}

	public void userExists(String username, String password) {
		for (int i = 0; i <= 2; i++) {
			if (employees.get(i).getUsername().equals(username) && employees.get(i).getPassword().equals(password)) {
				System.out.println("WELCOME");
			} else {
				System.out.println("ERROR");
			}
		}
	}
}
