package com.gk.ecart.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(UserNotFoundException.class)
public ModelAndView employeeNotFoundException(HttpServletRequest request,Exception ex) {
		
		ModelAndView modelAndView= new ModelAndView();
	return modelAndView;
	}

	/*
	 * //@ExceptionHandler(EmployeeNotFoundException.class) public @ResponseBody
	 * ExceptionJSONInfo handleEmployeeNotFoundException(HttpServletRequest request,
	 * Exception ex){
	 * 
	 * ExceptionJSONInfo response = new ExceptionJSONInfo();
	 * response.setUrl(request.getRequestURL().toString());
	 * response.setMessage(ex.getMessage());
	 * 
	 * return response; }
	 */
}
