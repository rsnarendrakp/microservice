package com.ecom.api.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan ("com.ecom.api.producer")
@EnableMongoRepositories("com.ecom.api.producer.mongo.repository")
@EnableEurekaClient
@EnableDiscoveryClient
public class EcomApiProducer {

	public static void main(String[] args) {
		SpringApplication.run(EcomApiProducer.class, args);
	}

}
