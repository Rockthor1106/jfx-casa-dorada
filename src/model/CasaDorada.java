package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	public void addClient(String name, String last_name, String id_number, String phone_number, String addres, String comments) {
		Client client = new Client(name, last_name, id_number, phone_number, addres, comments);
		if (clients.isEmpty()) {
			clients.add(client);
		}
		else {
			int i = 0;
			while(i < clients.size() && client.compareNameAndLastName(clients.get(i)) > 0) {
				i++;
			}
			clients.add(i,client);
		}

	}
	
	public int searchClients(String name, String last_name) {
		
		int pos = -1;
		int i = 0;
		int j = clients.size() - 1;
		
		while(i <= j && pos < 0) {
			int m = (i + j) / 2;
			if (clients.get(m).compareNameAndLastName(name + " " + last_name) == 0) {
				pos = m;
			}
			else if (clients.get(m).compareNameAndLastName(name + " " + last_name) < 0) {
				i = m + 1;
			}
			else {
				j = m - 1;
			}
		}
		
		return pos;	
	}
	
	public void importDataClients(String filename) throws IOException{
		BufferedReader bReader = new BufferedReader(new FileReader(filename));
		String line = bReader.readLine();
		while(line != null) {
			String[] parts = line.split(",");
			addClient(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5]);
			line = bReader.readLine();
		}
		bReader.close();
	}

}
