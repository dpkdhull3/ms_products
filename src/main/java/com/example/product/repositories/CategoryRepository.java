package com.example.product.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.product.entities.Category;


public interface CategoryRepository extends MongoRepository<Category, String>{


}
