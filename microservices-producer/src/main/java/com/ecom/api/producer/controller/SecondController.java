package com.ecom.api.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class SecondController {

	@GetMapping("/message")
	public String test(@RequestHeader("second-request") String header) {
		System.out.println(header);
		return "Hello JavaInUse Called in Second Service";
	}
}
