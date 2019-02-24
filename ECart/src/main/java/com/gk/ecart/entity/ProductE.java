package com.gk.ecart.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="item")
public class ProductE  {

	

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private String productId;
	
	@Column(name="category")
	private String productCategory;
	
	@Column(name="description")
	private String productDescription;
	
	@Column(name="manufacturer")
	private String productManufacturer;
	
	@Column(name="name")
	private String productName;
	
	@Column(name="price")
	private Double productPrice;
	
	@Column(name="unit")
	private String unitStock;
	
	@Transient
	private MultipartFile productImage;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductManufacturer() {
		return productManufacturer;
	}
	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public String getUnitStock() {
		return unitStock;
	}
	public void setUnitStock(String unitStock) {
		this.unitStock = unitStock;
	}
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	
}
