package com.gk.ecart.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.gk.ecart.entity.TestUserE;
import com.gk.ecart.entity.User;

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
	
	public void getUserList() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		org.hibernate.Transaction tx=session.beginTransaction();

		CriteriaBuilder cb=session.getCriteriaBuilder();
		CriteriaQuery<User> cquery= cb.createQuery(User.class);
		
		Root<User> userRoot= cquery.from(User.class);
		cquery.select(userRoot);
		
		org.hibernate.query.Query<User> users=session.createQuery(cquery);
		List<User> userList=users.getResultList();
		for(User u: userList) {
			System.out.println(u.getEmail());
		}
				
				
		
		
		
	}
}
