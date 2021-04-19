package model;

public class Ingredients {
	private String name_ingredient;
	private String availability;
	
	public Ingredients(String name_ingredient, String availability) {

		this.setName_ingredient(name_ingredient);
		this.setAvailability(availability);
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getName_ingredient() {
		return name_ingredient;
	}

	public void setName_ingredient(String name_ingredient) {
		this.name_ingredient = name_ingredient;
	}

	
}
