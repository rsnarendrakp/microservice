package com.ecom.api.producer.service;

import java.util.List;

import com.ecom.api.producer.domain.UserAddress;

public interface UserAddressService {

	void saveUserAddress(UserAddress userAddress);

	List<UserAddress> getAllAddress();
}
