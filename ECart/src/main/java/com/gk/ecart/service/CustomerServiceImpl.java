package com.gk.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gk.ecart.dao.CustomerDao;
import com.gk.ecart.entity.BillingAddressE;
import com.gk.ecart.entity.CartE;
import com.gk.ecart.entity.CustomerE;
import com.gk.ecart.entity.ShippingAddressE;
import com.gk.ecart.entity.UserE;
import com.gk.ecart.model.BillingAddress;
import com.gk.ecart.model.Customer;

public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerE customerE;
	@Autowired
	CustomerDao customerdao;

	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		ShippingAddressE shippingAddr= new ShippingAddressE();
		BillingAddressE  billingAddr= new BillingAddressE();
		UserE userE= new UserE();
		CartE cart = new CartE();
		
		
		shippingAddr.setAddress(customer.getShippingAddress().getAddress());
		shippingAddr.setCity(customer.getShippingAddress().getCity());
		shippingAddr.setCountry(customer.getShippingAddress().getCountry());
		shippingAddr.setState(customer.getShippingAddress().getState());
		shippingAddr.setZipcode(customer.getShippingAddress().getZipcode());
		
		billingAddr.setAddress(customer.getBillingAddress().getAddress());
		billingAddr.setCity(customer.getBillingAddress().getCity());
		billingAddr.setCountry(customer.getBillingAddress().getCountry());
		billingAddr.setState(customer.getBillingAddress().getState());
		billingAddr.setZipcode(customer.getBillingAddress().getZipcode());
		
		userE.setEmailId(customer.getUsers().getEmailId());
		userE.setPassword(customer.getUsers().getPassword());
		userE.setEnabled(true);
		
		customerE.setBillingAddress(billingAddr);
		customerE.setShippingAddress(shippingAddr);
		customerE.setFirstName(customer.getFirstName());
		customerE.setLastName(customer.getLastName());
		customerE.setCustomerPhone(customer.getCustomerPhone());
		customerE.setUser(userE);
		customerE.setCart(cart);
		
		customerdao.addCustomer(customerE);
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer getCustomerByemailId(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

}
