package model;

public abstract class Person  {
	
	private String name;
	private String last_name;
	private String id_number;
	
	public Person(String name, String last_name, String id_number) {
		this.name = name;
		this.last_name = last_name;
		this.id_number = id_number;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return last_name;
	}

	public String getIdNumber() {
		return id_number;
	}
	
}
