package com.hexagonal.product.arquitecture.adapters.outputs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexagonal.product.aplication.ports.outputs.ProductPersistencePort;
import com.hexagonal.product.arquitecture.adapters.outputs.model.ProductModel;
import com.hexagonal.product.arquitecture.adapters.outputs.repository.ProductModelRepository;
import com.hexagonal.product.domain.Product;
@Service
public class ProductPersistenceAdapter implements ProductPersistencePort{
	@Autowired
	ProductModelRepository productRepo;
	
	@Override
	public Product save(Product product) {
		ProductModel model=new ProductModel().fromProduct(product);
		model=productRepo.save(model);
		return model.toProduct();
	}

	@Override
	public List<Product> list() {
		System.out.println("Estoy en ProductPersistenceAdapter");
		return productRepo.findAll().stream().map(t -> t.toProduct()).toList();
	}

	@Override
	public Product getBySku(String sku) {
		ProductModel model = productRepo.findBySku(sku);
		if(model==null) {
			return null;
		}
		return model.toProduct();
	}

}
