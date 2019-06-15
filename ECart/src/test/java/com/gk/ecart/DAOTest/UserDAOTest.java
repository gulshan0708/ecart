package com.gk.ecart.DAOTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gk.ecart.dao.TestUserDAO;
import com.gk.ecart.daoimpl.UserDAOImpl;
import com.gk.ecart.entity.Address;
import com.gk.ecart.entity.Cart;
import com.gk.ecart.entity.User;



@RunWith(JUnitPlatform.class)
public class UserDAOTest {
	private static final Logger LOG = LogManager.getLogger(UserDAOTest.class);
	//private static AnnotationConfigApplicationContext context;
	private User user = null;
	private Address address= null;
	private Cart cart=null;
	@Autowired
	private static  TestUserDAO tuserDao ;
	@Autowired
	private static UserDAOImpl userDaoImpl;


	@BeforeAll
	public static void init() {
		LOG.info("Loginfo inside BeforeAll");
//		context = new AnnotationConfigApplicationContext();
//		context.scan("com.gk.ecart.dao");
//		context.refresh();
		

		//tuserDao =  (TestUserDAO) context.getBean("tuserDAO");
		//tuserDao =new TestUserDAO();
		userDaoImpl= new UserDAOImpl(); 

	}
	@BeforeEach
	public  void setup() {
		LOG.info("Loginfo inside BeforeEach");
		
	}
	
//	@Test
//	public void testGetUserByEmail() {
//		LOG.info("checking assertEqual");
//		String email="vk@gmail.com";
//		User user=tuserDao.getUserByEmail(email);
//		
//		String name=user.getFirstName();
//		LOG.info("checking");
//		LOG.info("name : "+name);
//		Assertions.assertEquals("Virat", name);
//	}
	
	
	
	
	
	
//	@DisplayName("Testing User by Email")
//	@Test
//	public void getUserByEmail(){
//		LOG.info("This Will Be Printed On Info");
//		LOG.info("Getting user");
//		
//		String email="vk@gmail.com";
//		User user=userDaoImpl.getByEmail(email);
//		LOG.info(user.getEmail());
//	
//		Assertions.assertEquals("vk@gmail.com",user.getEmail());
//		
//	}
	@DisplayName("Testing AddUser")
	@Test
	public void testAddUser() {
		LOG.info("Adding user");

		user=new User();
		user.setFirstName("Gulshan");
		user.setLastName("Kumar");
		user.setEmail("gulshankumar0708@gmail.com");
		user.setContactNumber("7004768019");
		user.setRole("Customer");
		user.setPassword("123456");
		user.setEnabled(true);
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		// linked the address with the user
        // address.setUserId(userId);
		
        cart=new Cart();
		cart.setGrandTotal(110);
		cart.setUser(user);
		cart.setCartLines(101);
		
		
	//	LOG.info("Adding User");
		String email="gulshankumar0708@gmail.com";
		userDaoImpl.add(user);
		
		//LOG.info("Gettin user by Email");
		User user1= userDaoImpl.getByEmail(email);
		
		LOG.info(user1.getFirstName());
		
	}
	
	
	@AfterAll
	public static void teardown() {
		LOG.info("Loginfo inside AfterAll");

	}

}
