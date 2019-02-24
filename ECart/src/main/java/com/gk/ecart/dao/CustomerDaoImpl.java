package com.gk.ecart.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gk.ecart.entity.CustomerE;



public class CustomerDaoImpl implements CustomerDao {
	
	
	private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

	public void addCustomer(CustomerE customerE) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.persist(customerE);
		
		tx.commit();
	}

	public List<CustomerE> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomerE getCustomerByemailId(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
