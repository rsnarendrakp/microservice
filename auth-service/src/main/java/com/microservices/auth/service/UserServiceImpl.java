package com.microservices.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.auth.dto.UserDto;
import com.microservices.auth.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository repository;
    
    List<UserDto> userList = new ArrayList < > ();

    @Override
    public void addUser(UserDto profile) {
        repository.save(profile);
    }

    @Override
    public List<UserDto> getUsers() {
        return repository.findAll();
    }

	@Override
	public UserDto getUserByLoginId(String loginId) {
		return repository.findByLoginId(loginId);
	}    
}
