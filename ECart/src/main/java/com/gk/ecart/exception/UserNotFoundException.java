package com.gk.ecart.exception;

import java.io.Serializable;

public class UserNotFoundException extends Exception implements Serializable{
	private static final long serialVersionUID = 1L;
	private String message;

	public UserNotFoundException(String message) {
		super();
		this.message =  System.currentTimeMillis() + ": " + message;
	}
	
	public UserNotFoundException() {
		this("User not found exception");
	}
}
