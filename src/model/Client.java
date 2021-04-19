package model;


public class Client extends Person {

	private String phone_number;
	private String addres;
	private String comments;
	private String fullname;

	public Client(String name,String last_name,String id_number,String phone_number, String addres, String comments) {
		super(name, last_name, id_number);
		this.phone_number = phone_number;
		this.addres = addres;
		this.comments = comments;
		this.fullname = name + " " + last_name;
	}

	public String getPhoneNumber() {
		return phone_number;
	}

	public String getAddres() {
		return addres;
	}

	public String getComments() {
		return comments;
	}
	
	public String getFullName() {
		return fullname;
	}
	
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int compareNameAndLastName(Client client) {
        return getFullName().compareToIgnoreCase(client.getFullName());
    }
	

	public int compareNameAndLastName(String clien_fullname) {
        return getFullName().compareToIgnoreCase(clien_fullname);
    }
	
}
