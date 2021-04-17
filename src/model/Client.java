package model;

public class Client extends Person {

	private String phone_number;
	private String addres;
//	private String comment;

	public Client(String name,String last_name,String id_number,String phone_number, String addres) {
		super(name, last_name, id_number);
		this.phone_number = phone_number;
		this.addres = addres;
//		this.comment = comment;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public String getAddres() {
		return addres;
	}

//	public String getComment() {
//		return comment;
//	}
	
    public int compareName(Client client) {
        return getName().compareTo(client.getName());
    }
    
    
    public int compareLastName(Client client) {
        return getLastName().compareTo(client.getLastName());
    }
}
