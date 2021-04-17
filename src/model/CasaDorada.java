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
		clients = new ArrayList<>();
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
	
	
	//add clients sorting them
	public void addClient(String name, String last_name, String id_number, String phone_number, String addres) {
		Client client = new Client(name, last_name, id_number, phone_number, addres);
		if (clients.isEmpty()) {
			clients.add(client);
		}
		else {
			int i = 0;
			while(i < clients.size() && client.compareName(clients.get(i)) > 0) {
				i++;
			}
			clients.add(i,client);
		}

	}
	
	public int binarySearch(String name, String last_name) {
		int pos = -1;
		int i = 0;
		int j = clients.size() - 1;
		
		while(i <= j && pos < 0) {
			int m = (i + j) / 2;
			if (clients.get(m).compareName(name) == 0 && clients.get(m).compareLastName(last_name) == 0) {
				pos = m;
			}
			else if (clients.get(m).compareName(name) < 0 && clients.get(m).compareLastName(last_name) < 0) {
				i = m + 1;
			}
			else {
				j = m - 1;
			}
		}
		
		return pos;	
	}

}
