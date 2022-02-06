package com.microservices.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;

import com.microservices.consumer.dto.UserAddressDto;
import com.microservices.consumer.feign.service.UserFeignClient;
import com.microservices.consumer.util.ApplicationUtil;

@RestController
@RequestMapping("user/address")
public class UserAddressController extends ApplicationUtil {
	//@Autowired
	//private RestTemplate restTemplate;
	@Autowired
	private UserFeignClient loadBalancer;
	
	@GetMapping("")
	public UserAddressDto[] getAttUserAddress(){
		//String url = getProducerUri()+"/user/address/";
		//return restTemplate.getForObject(url, UserDto[].class);
		return loadBalancer.getAllUserAddress();
	}
	
}
