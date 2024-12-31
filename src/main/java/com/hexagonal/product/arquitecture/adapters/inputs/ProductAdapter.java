package com.hexagonal.product.arquitecture.adapters.inputs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexagonal.product.aplication.ports.inputs.ProductPort;
import com.hexagonal.product.aplication.ports.outputs.ProductPersistencePort;
import com.hexagonal.product.domain.Product;
@Service
public class ProductAdapter implements ProductPort{
	
	@Autowired
	ProductPersistencePort portPersistence;

	@Override
	public Product saveProduct(Product p) {
		// TODO Auto-generated method stub
		return portPersistence.save(p);
	}

	@Override
	public List<Product> listProducts() {
		System.out.println("Estoy en ProductAdapter");
		return portPersistence.list();
	}

	@Override
	public Product getProductoBySku(String sku) {
		// TODO Auto-generated method stub
		return portPersistence.getBySku(sku);
	}

}
