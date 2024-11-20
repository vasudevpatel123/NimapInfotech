package com.tka.ShopOnline.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.ShopOnline.entity.Product;

@Repository
public class ProductDAO {

	@Autowired
	SessionFactory factory;
	
	public List<Product> getAllProducts(int pageNumber) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		List<Product> listProducts = null;
		int pageSize = 2;
		
		try {
			
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hqlQuery = "from Product";
			Query<Product> query = session.createQuery(hqlQuery, Product.class);
			query.setFirstResult((pageNumber-1)*pageSize);
			query.setMaxResults(pageSize);
			listProducts = query.getResultList();
			transaction.commit();
			
		}catch(Exception exception){
			if(transaction!=null)
				transaction.rollback();
			exception.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		
		return listProducts;
	}
	
	
	public String insertProduct(Product product) {
		
		Session session = null;
		Transaction transaction = null;
		String message = null;
		
		try {
			
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.persist(product);
			transaction.commit();
			message = "Product added Successfully...";
			
		}catch(Exception exception) {
			if(transaction!=null)
				transaction.rollback();
			exception.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		
		return message;
	}


	public Product getParticularProduct(int id) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction = null;
		Product product=null;
		
		try {
			
			session = factory.openSession();
			transaction = session.beginTransaction();
			product = session.get(Product.class, id);
			transaction.commit();
			
			
		}catch(Exception exception) {
			if(transaction!=null)
				transaction.rollback();
			exception.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		
		return product;
	}


	public String updateProduct(Product product, int id) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction = null;
		String message = null;
		
		try {
			
			session = factory.openSession();
			transaction = session.beginTransaction();
			Product productDAO = session.get(Product.class, id);
			productDAO.setPrice(product.getPrice());
			productDAO.setQuantity(product.getQuantity());
			productDAO.setName(product.getName());
			productDAO.setUpc(product.getUpc());
			productDAO.setCategory(product.getCategory());
			session.merge(productDAO);
			transaction.commit();
			message = "Product updated successfully";
			
		}catch(Exception exception) {
			if(transaction!=null)
				transaction.rollback();
			exception.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		
		return message;
	}


	public String deleteProduct(int id) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		String message = null;
		
		try {
			
			session = factory.openSession();
			transaction = session.beginTransaction();
			Product product = session.get(Product.class, id);
			session.remove(product);
			transaction.commit();
			message = "Product deleted Successfully";
			
		}catch(Exception exception) {
			if(transaction!=null)
				transaction.rollback();
			exception.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		
		return message;
	}
	
}


