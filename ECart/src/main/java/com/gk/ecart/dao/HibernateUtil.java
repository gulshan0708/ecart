package com.gk.ecart.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	private static void buildSessionFactory() {
		Configuration configuration= new Configuration().configure("hibernate.cfg.xml");
		//ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		  
		sessionFactory=configuration.buildSessionFactory();
	
	}

	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			buildSessionFactory();
		}
		return sessionFactory;
	}
	
}
