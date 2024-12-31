package com.hexagonal.product.aplication.ports.inputs;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexagonal.product.domain.Product;


public interface ProductPort {
	public Product saveProduct(Product product);
	public List<Product> listProducts();
	public Product getProductoBySku(String sku);

}
