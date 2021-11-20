package com.example.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.entities.ElasticProduct;
import com.example.product.entities.Product;
import com.example.product.repositories.ProductRepository;
import com.example.product.utils.ProductSequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductSequenceGeneratorService nextSequenceService;
	@Autowired
	private RestService restService;

	public Product saveProduct(Product product) {
		String id = nextSequenceService.getNextSequence("customSequences").toString();
		ElasticProduct ep = new ElasticProduct(product.getProductName(),product.getProductDescription(),product.getPrice(),product.getStocksQuantity(),product.getProductImage(),product.getDiscountPercentage());
		log.info("generated id "+id);
		product.setProductId(id);
		String elastricResponse = this.restService.addProductToElastic(id,ep).toString();
		// log.info("elastic",elastricResponse);
		return productRepository.save(product);
	}
	
	public Optional<Product> getProductById(String id) {
		return productRepository.findById(id);
	}
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
}
