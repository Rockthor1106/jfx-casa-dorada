package ui;

import java.util.Scanner;

import model.Employee;
import model.UserAccounts;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name, last_name, username, password;
		int id_number;
		
		

			System.out.println("SING UP");
			System.out.println("name: ");
			name = sc.nextLine();
			System.out.println("last name: ");
			last_name = sc.nextLine();
			System.out.println("ID number: ");
			id_number = Integer.parseInt(sc.nextLine());
			System.out.println("username: ");
			username = sc.nextLine();
			System.out.println("password: ");
			password = sc.nextLine();
			new UserAccounts().addEmployee(name, last_name, id_number, username, password);
			
		
			System.out.println("name: ");
			name = sc.nextLine();
			System.out.println("last name: ");
			last_name = sc.nextLine();
			System.out.println("ID number: ");
			id_number = Integer.parseInt(sc.nextLine());
			System.out.println("username: ");
			username = sc.nextLine();
			System.out.println("password: ");
			password = sc.nextLine();
			new UserAccounts().addEmployee(name, last_name, id_number, username, password);


		// login
		System.out.println("-----------LOG IN----------");
		System.out.println("Type your username: ");
		username = sc.nextLine();
		System.out.println("Type your password");
		password = sc.nextLine();
		new UserAccounts().userExists(username, password);
	}

}
