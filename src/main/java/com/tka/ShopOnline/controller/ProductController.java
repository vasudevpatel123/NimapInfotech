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

import com.tka.ShopOnline.entity.Product;
import com.tka.ShopOnline.service.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping()
	public List<Product> getAllProducts(@RequestParam(defaultValue = "1") int page){
		List<Product> listRecords = productService.getAllProducts(page);
		return listRecords;
	}
	
	@PostMapping()
	public String insertProduct(@RequestBody Product product) {
		String msg = productService.insertProduct(product);
		return msg;
	}
	
	@GetMapping("/{id}")
	public Product getParticularProduct(@PathVariable int id) {
		Product product = productService.getParticularProduct(id);
		return product;
	}
	
	@PutMapping("/{id}")
	public String updateProduct(@RequestBody Product product,@PathVariable int id) {
		String msg = productService.updateProduct(product, id);
		return msg;
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id){
		String message = productService.deleteProduct(id);
		return message;
	}
	
}
