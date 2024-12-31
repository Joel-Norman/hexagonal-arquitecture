package com.hexagonal.product.domain;

public class Product {
	String id;
	String sku;
	String name;
	String description;
	public Product() {
	}
	
	public Product(String id, String sku, String name, String description) {
		super();
		this.id = id;
		this.sku = sku;
		this.name = name;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}


