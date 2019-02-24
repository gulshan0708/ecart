package com.gk.ecart.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserE{



	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private String userId;
	private String emailId;
	private String password;
	private boolean enabled;
	
	@OneToOne(mappedBy="users")
	private CustomerE customer;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public CustomerE getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerE customer) {
		this.customer = customer;
	}
	
}
