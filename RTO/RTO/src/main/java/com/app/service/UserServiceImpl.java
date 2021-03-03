package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.Role;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;

	@Override
	public User authenticateUser(String email, String pwd) {

		return userDao.authenticateUser(email, pwd);
	}

	@Override
	public String registerUser(User transientUser) {
		transientUser.setRole(Role.CITIZEN);
		return userDao.registerUser(transientUser);
	}

	@Override
	public List<User> getAllUsers() {

		return userDao.getAllUsers();
	}

}
