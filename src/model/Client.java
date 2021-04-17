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

	public String getPhoneNumber() {
		return phone_number;
	}

	public String getAddres() {
		return addres;
	}

//	public String getComment() {
//		return comment;
//	}
	
	//compare using objects of Client type
    public int compareName(Client client) {
        return getName().compareTo(client.getName());
    }
    
    
    public int compareLastName(Client client) {
        return getLastName().compareTo(client.getLastName());
    }
    
   //compare using Strings with user´s name and last name 
    public int compareName(String str_client_name) {
        return getName().compareTo(str_client_name);
    }

    public int compareLastName(String str_client_lastname) {
        return getLastName().compareTo(str_client_lastname);
    }
  
}
