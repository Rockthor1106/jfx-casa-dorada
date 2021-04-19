package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private String code;
	private String state;
	private List<String> products = new ArrayList<>() ;
	private List<Integer> amount_product = new ArrayList<>();
	private String client;
	private String deliver;
	private String date;
	private String comments;

	public Order(String code,int state, String products, int amount_product, String client, String deliver, String date,String comments) {
		this.code = code;
		this.state = OrderState.values()[state].name();
		this.products.add(products);
		this.amount_product.add(amount_product);
		this.client = client;
		this.deliver = deliver;
		this.date = date;
		this.comments = comments;
	}

	public Order() {

	}

	public String getCode() {
		return code;
	}
	
	public String getState() {
		return state;
	}

	public List<String> getProducts() {
		return products;
	}
	
	public List<Integer> getAmountProduct() {
		return amount_product;
	}

	public String getClient() {
		return client;
	}

	public String getDeliver() {
		return deliver;
	}

	public String getDate() {
		return date;
	}

	public String getComments() {
		return comments;
	}

}
