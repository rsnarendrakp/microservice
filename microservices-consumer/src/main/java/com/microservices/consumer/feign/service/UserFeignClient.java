package com.microservices.consumer.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.microservices.consumer.common.Constants;
import com.microservices.consumer.dto.UserAddressDto;
import com.microservices.consumer.dto.UserDto;

@FeignClient(name=Constants.PRODUCER_APP_NAME,path =Constants.BASE_API_URL )
public interface UserFeignClient {
	
	@GetMapping(value="user")
	public UserDto[] getAllUsersData();

	@GetMapping(value="user/address/")
	public UserAddressDto[] getAllUserAddress();

}
