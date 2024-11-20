package com.tka.ShopOnline.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.ShopOnline.entity.Category;

@Repository
public class CategoryDAO {

	@Autowired
	SessionFactory factory;
	
	public List<Category> getAllCategories(int pageNumber) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		List<Category> listCategories = null;
		int pageSize = 2;
		
		try {
			
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hqlQuery = "from Category";
			Query<Category> query = session.createQuery(hqlQuery,Category.class);
			query.setFirstResult((pageNumber-1)*pageSize);
			query.setMaxResults(pageSize);
			listCategories = query.getResultList();
			transaction.commit();
		
		}catch(Exception exception) {
			if(transaction!=null)
				transaction.rollback();
			exception.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		
		return listCategories;
	}
	
	public String insertCategory(Category category) {
		
		Session session = null;
		Transaction transaction = null;
		String message = null;
		
		try {
			
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.persist(category);
			transaction.commit();
			message = "Category added Successfully...";
			
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


	public Category getParticularCategory(int id) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction = null;
		Category category=null;
		
		try {
			
			session = factory.openSession();
			transaction = session.beginTransaction();
			category = session.get(Category.class, id);
			transaction.commit();
			
			
		}catch(Exception exception) {
			if(transaction!=null)
				transaction.rollback();
			exception.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		
		return category;
	}


	public String updateCategory(Category category, int id) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction = null;
		String message = null;
		
		try {
			
			session = factory.openSession();
			transaction = session.beginTransaction();
			Category categoryDAO = session.get(Category.class, id);
			categoryDAO.setName(category.getName());
			session.merge(categoryDAO);
			transaction.commit();
			message = "Category updated successfully";
			
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


	public String deleteCategory(int id) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		String message = null;
		
		try {
			
			session = factory.openSession();
			transaction = session.beginTransaction();
			Category category = session.get(Category.class, id);
			session.remove(category);
			transaction.commit();
			message = "Category deleted Successfully";
			
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
