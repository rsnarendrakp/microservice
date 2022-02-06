package com.microservices.auth.service;

import java.util.List;

import com.microservices.auth.dto.UserDto;


public interface UserService {
	
	void addUser(UserDto user);

	List<UserDto> getUsers();

	UserDto getUserByLoginId(String loginId);
}
