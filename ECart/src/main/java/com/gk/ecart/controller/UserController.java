package com.gk.ecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gk.ecart.daoimpl.UserDAOImpl;
import com.gk.ecart.entity.User;
import com.gk.ecart.service.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@RequestMapping(value="/addUser")
	public String addUsser() {
		userServiceImpl.addUser();
		return "testlogin";
	}
	@RequestMapping(value="/getByEmail")
	public String getUserByEmail() {
		String email="vk@gmail.com";
		User user=userServiceImpl.getByEmail(email);
		System.out.println(user.getFirstName());
		return "testlogin";
	}
	@RequestMapping(value="/getById")
	public String getUserById() {
		int id=1;
		User user=userServiceImpl.getById(id);
		System.out.println(user.getFirstName());
		return "testlogin";
	}
}
