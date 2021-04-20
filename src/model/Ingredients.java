package model;

public class Ingredients {
	private String name_ingredient;
	private String availability;
	
	public Ingredients(String name_ingredient, int availability_num) {

		this.name_ingredient = name_ingredient;
		this.availability = IngredientAvailability.values()[availability_num].name();
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getNameIngredient() {
		return name_ingredient;
	}

	public void setName_ingredient(String name_ingredient) {
		this.name_ingredient = name_ingredient;
	}

	
}
