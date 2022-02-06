package com.ecom.api.producer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.api.producer.domain.UserAddress;
import com.ecom.api.producer.mongo.repository.UserAddressRepository;
import com.ecom.api.producer.service.UserAddressService;

@Service
public class UserAddressServiceImpl implements UserAddressService {

	@Autowired
	UserAddressRepository userAddressRepository;

	@Override
	public void saveUserAddress(UserAddress userAddress) {
		userAddressRepository.save(userAddress);
	}

	@Override
	public List<UserAddress> getAllAddress() {
		return userAddressRepository.findAll();
	}

}
