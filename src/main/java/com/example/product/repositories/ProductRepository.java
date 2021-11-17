package com.example.product.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.product.entities.Product;


public interface ProductRepository extends MongoRepository<Product, String>{


}
