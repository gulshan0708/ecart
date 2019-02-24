package com.gk.ecart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class CustomerE {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String customerId;
	private String firstName;
	private String lastName;
	private String customerPhone;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "shippingAddressId")
	private ShippingAddressE shippingAddress;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "billingAddressId")
	private BillingAddressE billingAddress;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private UserE user;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cartId")
	private CartE cart;
	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public ShippingAddressE getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddressE shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public BillingAddressE getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddressE billingAddress) {
		this.billingAddress = billingAddress;
	}
	public UserE getUser() {
		return user;
	}
	public void setUser(UserE user) {
		this.user = user;
	}
	public CartE getCart() {
		return cart;
	}
	public void setCart(CartE cart) {
		this.cart = cart;
	}
	
	
}
