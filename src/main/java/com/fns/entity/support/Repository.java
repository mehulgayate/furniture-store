package com.fns.entity.support;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fns.entity.Product;

public class Repository {
	
	@Resource
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	
	public List<Product> listAllProducts(){
		return getSession().createQuery("FROM "+Product.class.getName()).list();
	}
	
	public Product findProductById(Long id){
		return (Product) getSession().createQuery(" FROM "+Product.class.getName()+" p where p.id=:id")
				.setParameter("id", id).uniqueResult();
	}

}
