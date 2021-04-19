package model;

public class Product implements Comparable<Product>{
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

	@Override
	public int compareTo(Product product) {
		return 0;
//		return this.price-product.getPrice();	
	}

}
