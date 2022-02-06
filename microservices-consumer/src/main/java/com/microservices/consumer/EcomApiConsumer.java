package com.microservices.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
//import com.microservices.consumer.config.AppConfig;

@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan("com.microservices.consumer")
@SpringBootApplication
//@RibbonClient(name = "consumer",configuration =AppConfig.class)
public class EcomApiConsumer {

	public static void main(String[] args) {
		SpringApplication.run(EcomApiConsumer.class, args);
	}
}
