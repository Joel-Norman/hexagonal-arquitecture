package com.hexagonal.product.aplication.ports.outputs;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexagonal.product.domain.Product;

public interface ProductPersistencePort {
	
	public Product save(Product product);
	public List<Product> list();
	public Product getBySku(String sku);

}
