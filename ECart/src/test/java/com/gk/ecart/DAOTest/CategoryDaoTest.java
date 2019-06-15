package com.gk.ecart.DAOTest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.gk.ecart.daoimpl.CategoryDAOImpl;
import com.gk.ecart.entity.Category;

@RunWith(JUnitPlatform.class)
public class CategoryDaoTest {
	private static final Logger LOG= LogManager.getLogger(CategoryDaoTest.class);
	@Autowired
	static CategoryDAOImpl categorydao;
	@BeforeAll
	public static void init() {
		categorydao= new CategoryDAOImpl();
		LOG.info("categorydao object intantiated in before all");
	}
	@BeforeEach
	public void beforeEachMethodSetup() {
		LOG.info("before each method setup done");
	}
	
	@Disabled
	@DisplayName("get Category by providing id")
	@Test
	public void getCategory() {
		Category category=categorydao.get(1);
		Assertions.assertEquals("Laptop", category.getName());
	}
	
	@Disabled
	@DisplayName("get Category list by providing id")
	@Test
	public void getCategoryList() {
		List<Category> categorylist=categorydao.list();
		Assertions.assertEquals(5, categorylist.size());
	}
	
	@Disabled
	@DisplayName("Adding categogry")
	@Test
	public void addCategory() {
		Category category= new Category();
		category.setName("Mi A1");
		category.setDescription("This is my mobile");
		category.setImageURL("not available");
		category.setActive(true);
		
		boolean result=categorydao.add(category);
		Assertions.assertTrue(result);
		
	}
	@Disabled
	@DisplayName("updating categogry")
	@Test
	public void updateCategory() {
		Category category= new Category();
		category.setId(4);
		category.setName("Mi A1");
		category.setDescription("This is my mobile");
		category.setImageURL("MiA1.png");
		category.setActive(true);
		
		boolean result=categorydao.update(category);
		Assertions.assertTrue(result);
		
	}
	
	@Disabled
	@DisplayName("Deactivate category")
	@Test
	public void deleteCategory() {
		Category category= new Category();
		category.setId(4);
		category.setName("Mi A1");
		category.setDescription("This is my mobile");
		category.setImageURL("MiA1.png");
	//	category.setActive(true);
		
		boolean result=categorydao.delete(category);
		Assertions.assertTrue(result);
	}
	
	
	@AfterEach
	public void afterEachMethoddestroy() {
		LOG.info("After each method destroy called");
	}
	
	@AfterAll
	public static void destroy() {
		categorydao=null;
		LOG.info("categorydao object destroyed");
	}

}
