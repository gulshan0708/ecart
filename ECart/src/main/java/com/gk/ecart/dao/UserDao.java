package com.gk.ecart.dao;

import java.util.List;

import com.gk.ecart.entity.UserE;

public interface UserDao {
	List<UserE> getAllUsers();

	void deleteUser(String userId);
	
	void addUser(UserE user);
	
	UserE getUserById(String userId);
}
