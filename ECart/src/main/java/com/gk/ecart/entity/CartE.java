package com.gk.ecart.entity;

import java.io.Serializable;
import java.util.List;

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
@Table(name="cart")
public class CartE implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String cartId;
	
	@OneToOne
	@JoinColumn(name="customerId")
	private CustomerE customer;
	
	@OneToOne(mappedBy="cart",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	List<CartItemE> cartItems;
	
	private double price;
	
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public CustomerE getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerE customer) {
		this.customer = customer;
	}
	public List<CartItemE> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItemE> cartItems) {
		this.cartItems = cartItems;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
