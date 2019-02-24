package com.gk.ecart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cartitem")
public class CartItemE {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String cartItemId;
	private int quality;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private ProductE product;
	
	@ManyToOne
	@JoinColumn(name="cartId")
	private CartE cart;
	
	public String getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ProductE getProduct() {
		return product;
	}
	public void setProduct(ProductE product) {
		this.product = product;
	}
	public CartE getCart() {
		return cart;
	}
	public void setCart(CartE cart) {
		this.cart = cart;
	}
	
	
	
}
