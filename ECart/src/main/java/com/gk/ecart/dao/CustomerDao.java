package com.gk.ecart.dao;

import java.util.List;

import com.gk.ecart.entity.CustomerE;



public interface CustomerDao {

	void addCustomer(CustomerE customerE);

	List<CustomerE> getAllCustomers();

	CustomerE getCustomerByemailId(String emailId);

}
