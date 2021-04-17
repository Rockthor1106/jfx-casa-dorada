package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private String code;
	List<Product> products;
	List<Product> products_amount;
	private String client;
	private String deliver;
	private Date date;
	private String comments;

	public Order(String code, List<Product> products, String client, String deliver, Date date,
			String comments) {
		this.code = code;
		this.products = products;
		this.client = client;
		this.deliver = deliver;
		this.date = date;
		this.comments = comments;
		products = new ArrayList<>();
		products_amount = new ArrayList<>();
	}

	public String getCode() {
		return code;
	}

	public List<Product> getProducts() {
		return products;
	}

	public String getClient() {
		return client;
	}

	public String getDeliver() {
		return deliver;
	}

	public Date getDate() {
		return date;
	}

	public String getComments() {
		return comments;
	}

}
