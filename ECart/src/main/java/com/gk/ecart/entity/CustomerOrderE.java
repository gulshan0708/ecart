package com.gk.ecart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customerorder")
public class CustomerOrderE {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String customerOrderId;
	
	@OneToOne
	@JoinColumn(name = "cartId")
	private CartE cart;
	
	@OneToOne
	@JoinColumn(name = "customerId")
	private CustomerE customer;
	
	@OneToOne
	@JoinColumn(name = "shippingAddressId")
	private ShippingAddressE shippingAddress;
	
	@OneToOne
	@JoinColumn(name = "billingAddressId")
	private BillingAddressE billingAddress;
	
	public String getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(String customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public CartE getCart() {
		return cart;
	}
	public void setCart(CartE cart) {
		this.cart = cart;
	}
	public CustomerE getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerE customer) {
		this.customer = customer;
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
	
	
	

}
