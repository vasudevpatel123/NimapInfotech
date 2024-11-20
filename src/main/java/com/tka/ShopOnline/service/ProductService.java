package com.tka.ShopOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.ShopOnline.dao.ProductDAO;
import com.tka.ShopOnline.entity.Product;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDAO;
	
	public List<Product> getAllProducts(int pageNumber) {
		// TODO Auto-generated method stub
		List<Product> listProducts = productDAO.getAllProducts(pageNumber);
		return listProducts;
	}
	
	public String insertProduct(Product product) {
		String msg = productDAO.insertProduct(product);
		return msg;
	}

	public Product getParticularProduct(int id) {
		// TODO Auto-generated method stub
		Product product = productDAO.getParticularProduct(id);
		return product;
	}

	public String updateProduct(Product product, int id) {
		// TODO Auto-generated method stub
		String message = productDAO.updateProduct(product, id);
		return message;
	}

	public String deleteProduct(int id) {
		// TODO Auto-generated method stub
		String message = productDAO.deleteProduct(id);
		return message;
	}
	
}
