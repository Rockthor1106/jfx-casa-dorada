package model;


public class Product{

	private String name_product;
	private String type;
	private String ingredient;
	private String size;
	private double price;
	
	public Product(String name_product, String type, String ingredient, String size, double price) {
		this.name_product = name_product;
		this.type = type;
		this.ingredient = ingredient;
		this.size = size;
		this.price = price;
	}

	public String getNameProduct() {
		return name_product;
	}
	
	public String getType() {
		return type;
	}

	public String getIngredient() {
		return ingredient;
	}

	public String getSize() {
		return size;
	}

	public double getPrice() {
		return price;
	}
	
	//this method is use to search by name 
	
	public int compareNameProduct(String product_name) {
        return getNameProduct().compareToIgnoreCase(product_name);
    }

}
