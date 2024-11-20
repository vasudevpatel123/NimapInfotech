package com.tka.ShopOnline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.ShopOnline.entity.Category;
import com.tka.ShopOnline.service.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	  
	@GetMapping()
	public List<Category> getAllCategories(@RequestParam(defaultValue = "1") int page) {
		List<Category> listCategories = categoryService.getAllCategories(page);
		return listCategories;
	}
	
	@PostMapping()
	public String insertCategory(@RequestBody Category category) {
		String msg = categoryService.insertCategory(category);
		return msg;
	}
	
	@GetMapping("/{id}")
	public Category getParticularCategory(@PathVariable int id) {
		Category category = categoryService.getParticularCategory(id);
		return category;
	}
	
	@PutMapping("/{id}")
	public String updateCategory(@RequestBody Category category,@PathVariable int id) {
		String msg = categoryService.updateCategory(category, id);
		return msg;
	}
	 
	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable int id){
		String message = categoryService.deleteCategory(id);
		return message;
	}
	
}
