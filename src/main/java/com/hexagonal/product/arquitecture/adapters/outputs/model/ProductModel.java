package com.hexagonal.product.arquitecture.adapters.outputs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hexagonal.product.domain.Product;


@Document(collection = "collec_product")
public class ProductModel {
	@Id
	String id;
	String name;
	String description;
	String sku;
	
	public ProductModel() {
	}
	public ProductModel(String id, String name, String description, String sku) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.sku = sku;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public final ProductModel fromProduct(Product p) {
		return new ProductModel(p.getId(),p.getName(),p.getDescription(),p.getSku());
	}
	public final Product toProduct() {
		return new Product(id,sku,name,description);
	}
}
