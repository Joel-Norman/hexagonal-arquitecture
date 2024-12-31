package com.hexagonal.product.arquitecture.adapters.outputs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hexagonal.product.arquitecture.adapters.outputs.model.ProductModel;

@Repository
public interface ProductModelRepository extends MongoRepository<ProductModel, Long> {
	public ProductModel findBySku(String sku);

}
