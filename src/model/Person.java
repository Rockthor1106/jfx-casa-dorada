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

	public String getLast_name() {
		return last_name;
	}

	public String getId_number() {
		return id_number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
	
	
}
