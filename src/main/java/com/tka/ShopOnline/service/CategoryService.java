package com.tka.ShopOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.ShopOnline.dao.CategoryDAO;
import com.tka.ShopOnline.entity.Category;

@Service
public class CategoryService {


	@Autowired
	CategoryDAO categoryDAO;
	
	public List<Category> getAllCategories(int pageNumber) {
		// TODO Auto-generated method stub
		List<Category> listCategories = categoryDAO.getAllCategories(pageNumber);
		return listCategories;
	}
	
	public String insertCategory(Category category) {
		String msg = categoryDAO.insertCategory(category);
		return msg;
	}

	public Category getParticularCategory(int id) {
		// TODO Auto-generated method stub
		Category category = categoryDAO.getParticularCategory(id);
		return category;
	}

	public String updateCategory(Category category, int id) {
		// TODO Auto-generated method stub
		String message = categoryDAO.updateCategory(category, id);
		return message;
	}

	public String deleteCategory(int id) {
		// TODO Auto-generated method stub
		String message = categoryDAO.deleteCategory(id);
		return message;
	}
	
}
