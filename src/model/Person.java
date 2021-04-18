package model;

public abstract class Person  {
	
	private String name;
	private String last_name;
	private String id_number;
	private String fullname;
	
	public Person(String name, String last_name, String id_number) {
		this.name = name;
		this.last_name = last_name;
		this.id_number = id_number;
		this.fullname = name + " " + last_name;
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
	
	public String getFullName() {
		return fullname;
	}
	
    public int compareNameAndLastName(Client client) {
        return getFullName().compareTo(client.getFullName());
    }

    public int compareNameAndLastName(String client_fullname) {
        return getFullName().compareTo(client_fullname);
    }
	
}
