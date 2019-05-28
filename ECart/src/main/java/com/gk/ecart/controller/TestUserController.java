package com.gk.ecart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gk.ecart.entity.User;
import com.gk.ecart.exception.UserNotFoundException;
import com.gk.ecart.model.TestUser;
import com.gk.ecart.service.TestUserService;
@Controller
public class TestUserController {

	@Autowired
	TestUserService testUserService;
	
	private static final Logger LOGGER = LogManager.getLogger(TestUserController.class.getName());
	
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
	@RequestMapping(value="/getUserlist")
	@ResponseBody
	public List<User>  getUserList(){
		LOGGER.debug("Debug Message Logged !!!");
        LOGGER.info("Info Message Logged !!!");
       // LOGGER.error("Error Message Logged !!!", new NullPointerException("NullError"));
        List<User> userList=testUserService.getUserList();
        for(User u: userList) {
			System.out.println(u.getEmail());
		}
		return userList;
	}
	
	@ExceptionHandler
	public ModelAndView employeeNotFoundException(HttpServletRequest request,Exception ex) {
		
		ModelAndView modelAndView= new ModelAndView();
	return modelAndView;
	}
}
