package com.gk.ecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gk.ecart.model.TestUser;
import com.gk.ecart.service.TestUserService;
@Controller
public class TestUserController {

	@Autowired
	TestUserService testUserService;
	
	@RequestMapping(value= "/testregister")
	public String getRegistrationForm() {

		return "testregister";
	}

	@RequestMapping(value = "/testuser/registration", method = RequestMethod.POST)
	public String registerCustomer(@ModelAttribute(value = "testUser") TestUser testUser, Model model,
			BindingResult result) {
		if (result.hasErrors())
			return "testregister";

		
		System.out.println(testUser.getFirstName());
		System.out.println(testUser.getLastName());
		System.out.println(testUser.getEmailId());
		System.out.println(testUser.getPhoneNo());
		System.out.println(testUser.getPassword());

		testUserService.addTestUser(testUser);

		model.addAttribute("registrationSuccess", "Registered Successfully. Login using username and password");

		return "testlogin";
	}
}
