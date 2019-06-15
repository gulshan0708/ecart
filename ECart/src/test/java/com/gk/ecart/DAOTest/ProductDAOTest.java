package com.gk.ecart.DAOTest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.gk.ecart.daoimpl.ProductDAOImpl;
import com.gk.ecart.entity.Product;
@RunWith(JUnitPlatform.class)
public class ProductDAOTest {

//	Product get(int productId);
//	List<Product> list();
//	
//	boolean add(Product product);
//	boolean update(Product product);
//	boolean delete(Product product);
//	
//	List<Product> getProductsByParam(String param, int count);	
//	
//	// business methods
//		List<Product> listActiveProducts();	
//		List<Product> listActiveProductsByCategory(int categoryId);
//		List<Product> getLatestActiveProducts(int count);
	@Autowired
	static ProductDAOImpl productDaoImpl;
	
	private static final Logger LOG = LogManager.getLogger(UserDAOTest.class);
    @BeforeAll
	public static void init() {
		productDaoImpl=new ProductDAOImpl();
	}
    @Disabled
    @DisplayName("Test of getting Product by it's productId")
	@Test
	public void getByProductId() {
		LOG.info("Inside test and getting product");
		Product product=productDaoImpl.get(1);
		Assertions.assertEquals("apple", product.getBrand());
		LOG.info("Test completed");
	}
    @Disabled
    @DisplayName("getting list of product")
    @Test
    public void getProductList() {
    	List arrl=productDaoImpl.list();
    	Assertions.assertEquals(6, arrl.size());
    	
    }
    @Disabled
    @DisplayName("Adding product test")
    @Test
    public void addProduct() {
    	Product product = new Product();
    	product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is some description for oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
    	

		Assertions.assertEquals(true,productDaoImpl.add(product));		
		
		
		// reading and updating the category
//		product = productDaoImpl.get(2);
//		product.setName("Samsung Galaxy S7");
    }
    
    @Disabled
    @DisplayName("testing updation of Product")
    @Test
    public void updateProduct() {
    	Product product= productDaoImpl.get(2);
    	LOG.info(product.getName());
    	product.setName("Samsung Galaxy s7");
    	productDaoImpl.update(product);
    	
    	Assertions.assertEquals("Samsung Galaxy s7", productDaoImpl.get(2).getName());
    }
    @Disabled
    @DisplayName("deleting product")
    @Test
    public void deleteProduct() {
    	Product product= productDaoImpl.get(8);
    	boolean flag=productDaoImpl.delete(product);
    	Assertions.assertEquals(true,flag );
    }
    @Disabled
    @Test
    public void getProductByParam() {
    	List<Product> productList=productDaoImpl.getProductsByParam("id", 10);
    	
    	Assertions.assertEquals(10, productList.size());
    }
	
    @Disabled
    @DisplayName("active list by category")
    @Test
    public void listActiveProductByCategory() {
    	List<Product> productList=productDaoImpl.listActiveProductsByCategory(3);
    	
    	Assertions.assertEquals(4, productList.size());
    	
    }
    @Disabled
    @DisplayName("active product list")
    @Test
    public void getLatestActiveProducts() {
    	List<Product> productList=productDaoImpl.getLatestActiveProducts(3);
    	
    	Assertions.assertEquals(4, productList.size());
    	
    }
	@AfterAll
	public static void destroy() {
		LOG.info("Called in afterall");
	}
	
}
