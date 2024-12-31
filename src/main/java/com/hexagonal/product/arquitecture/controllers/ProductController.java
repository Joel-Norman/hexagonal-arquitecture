package com.hexagonal.product.arquitecture.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.product.aplication.ports.inputs.ProductPort;
import com.hexagonal.product.domain.Product;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
	@Autowired
	ProductPort portProduct;
	
	@PostMapping
	public ResponseEntity<Product> saveProducts(@RequestBody Product product){
		return new ResponseEntity<Product>(portProduct.saveProduct(product),HttpStatus.CREATED);
	}
	@GetMapping()
	public ResponseEntity<List<Product>> getProducts(){
		System.out.println("Estoy en ProductController");
		return new ResponseEntity<List<Product>>(portProduct.listProducts(),HttpStatus.OK);
	}
	@GetMapping("/holla")
	public ResponseEntity<String> getProductSku(){
		return new ResponseEntity<String>("HOla mundo",HttpStatus.FOUND);
	}

	@GetMapping("/{sku}")
	public ResponseEntity<Product> getProductSku(@PathVariable String sku){
		return new ResponseEntity<Product>(portProduct.getProductoBySku(sku),HttpStatus.FOUND);
	}
}
