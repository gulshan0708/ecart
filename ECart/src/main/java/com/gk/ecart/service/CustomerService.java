package com.gk.ecart.service;

import java.util.List;

import com.gk.ecart.model.Customer;

public interface CustomerService {
	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerByemailId(String emailId);
}
