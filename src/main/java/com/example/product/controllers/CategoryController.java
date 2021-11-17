package com.example.product.controllers;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.entities.Category;
import com.example.product.services.CategoryService;

import lombok.extern.slf4j.Slf4j;


@CrossOrigin
@RestController
@RequestMapping("/categories")
@Slf4j
public class CategoryController {

	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public Category saveCategory(@RequestBody Category category) {
		Category cat = categoryService.saveCategory(category);
		return cat;
	}
	
	@GetMapping("/{id}")
	public Optional<Category> findCategoryById(@PathVariable("id") String id) {
		return categoryService.getCategoryById(id);
	}
	
	@GetMapping("/")
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}

}
