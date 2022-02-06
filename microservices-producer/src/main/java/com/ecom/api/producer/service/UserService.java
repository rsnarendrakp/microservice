package com.ecom.api.producer.service;

import java.util.List;

import com.ecom.api.producer.domain.User;

public interface UserService {
	
	void addUser(User user);

	List<User> getUsers();

	User getUserById(Integer id);
}