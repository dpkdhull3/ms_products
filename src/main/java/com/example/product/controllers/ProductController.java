package com.example.product.controllers;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.entities.Product;
import com.example.product.services.ProductService;

import lombok.extern.slf4j.Slf4j;


@CrossOrigin
@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/")
	public Product saveProduct(@RequestBody Product product) {
		Product p = productService.saveProduct(product);
		log.info("inside product controller post"+p.getProductName());
		return p;
	}
	
	@GetMapping("/{id}")
	public Optional<Product> findProductById(@PathVariable("id") String id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

}
