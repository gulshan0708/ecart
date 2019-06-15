package com.gk.ecart.dao;

import java.util.List;

import com.gk.ecart.entity.Product;

public interface ProductDAO {

	Product get(int productId);
	List<Product> list();
	
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	boolean deactivate(Product product);
	
	List<Product> getProductsByParam(String param, int count);	
	
	// business methods
		List<Product> listActiveProducts();	
		List<Product> listActiveProductsByCategory(int categoryId);
		List<Product> getLatestActiveProducts(int count);
}
