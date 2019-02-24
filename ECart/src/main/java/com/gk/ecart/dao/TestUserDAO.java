package com.gk.ecart.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.gk.ecart.entity.TestUserE;

@Repository
public class TestUserDAO {

	
	
	
	public void addTestUser(TestUserE tuser) {
		System.out.println("Inside DAo clas");
		System.out.println(tuser.getEmailId());
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		org.hibernate.Transaction tx=session.beginTransaction();


	try {	
		session.save(tuser);
		System.out.println("user saved successfully");
		tx.commit();
		}
	finally {
		session.close();
		sf.close();
	}
		
	}
}
