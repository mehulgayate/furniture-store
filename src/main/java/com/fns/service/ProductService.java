package com.fns.service;

import java.io.IOException;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.evalua.entity.support.DataStoreManager;
import com.fns.entity.Product;
import com.fns.entity.support.ProductForm;


public class ProductService {

	
	private SessionFactory sessionFactory;	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private DataStoreManager dataStoreManager;
	public void setDataStoreManager(DataStoreManager dataStoreManager) {
		this.dataStoreManager = dataStoreManager;
	}

	public void saveProduct(ProductForm productForm) throws IOException{
		
		Product product=new Product();
		
		product.setName(productForm.getName());
		product.setStatus(productForm.getStatus());
		product.setStock(productForm.getStock());
		System.out.println(getSession());
		System.out.println(productForm.getPicture());
		product.setPicture(Hibernate.getLobCreator(getSession()).createBlob(productForm.getPicture().getBytes()));
		product.setPictureFileName(productForm.getPicture().getOriginalFilename());
		product.setPictureContectType(productForm.getPicture().getContentType());		
		
		dataStoreManager.save(product);
		
	}
	
	Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
