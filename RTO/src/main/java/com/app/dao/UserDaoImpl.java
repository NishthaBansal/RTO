package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Role;
import com.app.pojos.User;

@Repository
public class UserDaoImpl implements IUserDao {
	@Autowired
	private EntityManager mgr;

	@Override
	public User authenticateUser(String email, String pwd) {
		String jpql = "select u from User u where u.email=:em and u.password=:pass";

		return mgr.createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", pwd).getSingleResult();
	}

	@Override
	public String registerUser(User u) {
		mgr.persist(u);
		return u.getFirstName() + " register successfully !!  ";
	}

	@Override
	public List<User> getAllUsers() {
		String jpql = "select u from User u where u.role=:role";
		return mgr.createQuery(jpql, User.class).setParameter("role", Role.CITIZEN).getResultList();
	}

}
