package com.gk.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.ecart.dao.TestUserDAO;
import com.gk.ecart.entity.TestUserE;
import com.gk.ecart.entity.User;
import com.gk.ecart.model.TestUser;
@Service
public class TestUserService {
@Autowired
 TestUserDAO tuserDao;
	
	public void addTestUser(TestUser testUser) {
		System.out.println("Inside Service class");
		System.out.println(testUser.getEmailId());
		
		TestUserE tuser=new TestUserE();
		tuser.setEmailId(testUser.getEmailId());
		tuser.setFirstName(testUser.getFirstName());
		tuser.setLastName(testUser.getLastName());
		tuser.setPassword(testUser.getPassword());
		tuser.setPhoneNo(testUser.getPhoneNo());
		
		tuserDao.addTestUser(tuser);
	}
	
public List<User> getUserList(){
		
		return tuserDao.getUserList();
	}

public User getByEmail(String email){
	
	return tuserDao.getUserByEmail(email);
}
}
