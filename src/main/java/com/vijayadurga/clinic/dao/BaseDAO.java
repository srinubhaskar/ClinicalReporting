package com.vijayadurga.clinic.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vijayadurga.clinic.entity.ClinicalTest;

public abstract class BaseDAO<Element, Key extends Serializable> {

	@Autowired
	private SessionFactory factory;
	
	
	public void saveOrUpdate(final Object entity) {
		getCurrentSession().saveOrUpdate(entity);
	}
	
	public Object find(Class<Element> clazz, Key id) {
		return getCurrentSession().get(clazz, id);
	}
	
	public List<Element> findAll(Class<Element> clazz) {
		return getCurrentSession().createQuery("from "+clazz.getName()).getResultList();
	}
	
	public Object find(String query){
		return getCurrentSession().createQuery(query);
	}
	
	public Session getCurrentSession() {
		return factory.getCurrentSession();
	}
	
}
