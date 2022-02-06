package com.ecom.api.producer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.api.producer.domain.User;
import com.ecom.api.producer.repository.UserRepository;
import com.ecom.api.producer.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;
    
    List<User> userList = new ArrayList < > ();

    @Override
    public void addUser(User profile) {
        repository.save(profile);
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

	@Override
	public User getUserById(Integer id) {
		return repository.getById(id);
	}    
}