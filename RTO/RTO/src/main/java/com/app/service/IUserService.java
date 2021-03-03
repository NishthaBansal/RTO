package com.app.service;

import java.util.List;

import com.app.pojos.User;

public interface IUserService {
	User authenticateUser(String email, String pwd);

	String registerUser(User transientUser);

	List<User> getAllUsers();
}
