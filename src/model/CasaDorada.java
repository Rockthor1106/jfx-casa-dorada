package model;

import java.util.ArrayList;
import java.util.List;



public class CasaDorada {

	private List<Employee> employees;
	private List<Product> products;
	private List<Client> clients;
	
	public CasaDorada() {
		employees = new ArrayList<>();
		products = new ArrayList<>();
	}
	
	//Employee
	
	public void addEmployee(String name, String last_name, String id_number, String username, String password) {
		employees.add(new Employee(name, last_name, id_number, username, password));
	}
	
	public List<Employee> getEmployees(){
		return employees; 
	}
	
	//Product
	public void addProduct(String name_product, String ingredients, String size, double price) {
		products.add(new Product(name_product, ingredients,size,price));
	}
	
	public List<Product> getProducts(){
		return products; 
	}
	
	public List<Client> getClients(){
		return clients; 
	}
	
	public void addClient(String name, String last_name, String id_number, String phone_number, String addres) {
		clients.add(new Client(name, last_name, id_number,phone_number , addres));
	}
    
}
