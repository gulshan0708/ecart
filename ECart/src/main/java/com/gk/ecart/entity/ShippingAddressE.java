package com.gk.ecart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ShippingAddressE")
public class ShippingAddressE {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String shippingAddressId;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	
	@OneToOne(mappedBy = "ShippingAddressE")
	private CustomerE customer;
	public String getShippingAddressId() {
		return shippingAddressId;
	}
	public void setShippingAddressId(String shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public CustomerE getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerE customer) {
		this.customer = customer;
	}
	
	
}
