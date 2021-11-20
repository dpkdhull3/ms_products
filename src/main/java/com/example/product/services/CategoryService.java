package com.example.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.entities.Category;
import com.example.product.repositories.CategoryRepository;
import com.example.product.utils.CategorySequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategorySequenceGeneratorService nextSequenceService;

	public Category saveCategory(Category category) {
		String catId = nextSequenceService.getNextSequence("customSequences").toString();
		log.info("generated id "+catId);
		category.setCategoryId(catId);
		return categoryRepository.save(category);
	}
	
	public Optional<Category> getCategoryById(String id) {
		return categoryRepository.findById(id);
	}
	
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
}
