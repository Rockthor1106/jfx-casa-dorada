package model;

import java.util.ArrayList;
import java.util.List;



public class CasaDorada {

	private List<Employee> employees;
	
	public CasaDorada() {
		employees = new ArrayList<>();
	}
	
	public void addEmployee(String name, String last_name, String id_number, String username, String password) {
		employees.add(new Employee(name, last_name, id_number, username, password));
	}
	
	public List<Employee> getEmployees(){
		return employees; 
	}
}
