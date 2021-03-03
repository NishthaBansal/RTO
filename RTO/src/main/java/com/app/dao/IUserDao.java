package com.app.dao;

import java.util.List;

import com.app.pojos.User;

public interface IUserDao {

	User authenticateUser(String email, String pwd);

	String registerUser(User transientUser);

	List<User> getAllUsers();

}
