package com.gk.ecart.dao;

import java.util.List;

import com.gk.ecart.entity.Address;
import com.gk.ecart.entity.User;

public interface UserDAO {

	
	//User related operation
	User getByEmail(String email);
	User get(int id);
    
	boolean add(User user);
	
	//Address related
	Address getAddress(int addressId);
	
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	
	Address getBillingAddress(int userId);
	
	List<Address> listShippingAddress(int userId);
	
}
