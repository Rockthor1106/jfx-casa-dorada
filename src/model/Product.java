package model;

public class Product {
	private String product_name;
	private String ingredient;
	private int size;
	private double price;

	public Product(String product_name, String ingredient, int size, double price) {
		this.product_name = product_name;
		this.ingredient = ingredient;
		this.size = size;
		this.price = price;
	}

	public String getProduct_name() {
		return product_name;
	}

	public String getIngredient() {
		return ingredient;
	}

	public int getSize() {
		return size;
	}

	public double getPrice() {
		return price;
	}

}
