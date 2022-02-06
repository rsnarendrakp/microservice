package com.microservices.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;

import com.microservices.consumer.dto.UserDto;
import com.microservices.consumer.feign.service.UserFeignClient;
import com.microservices.consumer.util.ApplicationUtil;

@RestController
@RequestMapping("user")
public class UserController extends ApplicationUtil{

	//@Autowired
	//private RestTemplate restTemplate;
	@Autowired
	private UserFeignClient loadBalancer;
	//private static final String BASE_API_URL="/api_v1/user";
	@GetMapping("")
	public UserDto[] getAttUsers(){
		//String url = getProducerUri()+BASE_API_URL;
		//return restTemplate.getForObject(url, UserDto[].class);
		return loadBalancer.getAllUsersData();
	}
	/*
	@GetMapping("/{id}")
	public UserDto getUserById(@PathVariable Integer id) {
		String url = getProducerUri()+BASE_API_URL + "/{id}";
		return restTemplate.getForObject(url, UserDto.class, id);
	}*/
}
