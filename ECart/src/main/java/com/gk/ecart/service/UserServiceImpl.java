package com.gk.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.ecart.daoimpl.UserDAOImpl;
import com.gk.ecart.entity.User;

@Service
public class UserServiceImpl {
	private User user;
	@Autowired
	private UserDAOImpl userDaoImpl;

	public void addUser() {
		System.out.println("In Service impl");
		user = new User();
		user.setFirstName("Gulshan");
		user.setLastName("Kumar");
		user.setEmail("gulshankumar0708@gmail.com");
		user.setContactNumber("7004768019");
		user.setRole("Customer");
		user.setPassword("123456");
		user.setEnabled(true);
		try {
			System.out.println("calling dao method to add user");
			userDaoImpl.add(user);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public User getByEmail(String email) {

		return userDaoImpl.getByEmail(email);
	}

	public User getById(int id) {

		return userDaoImpl.get(id);
	}
}
