package com.microservices.consumer.util;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import com.microservices.consumer.common.Constants;

public class ApplicationUtil {

	/*@Autowired
	private DiscoveryClient discoveryClient;

	public String getProducerUri() {
		List<ServiceInstance> instances = discoveryClient.getInstances(Constants.RODUCER_APP_NAME);
		ServiceInstance instance = instances.get(0);
		String baseUrl = instance.getUri().toString();		
		return baseUrl;
	}*/
	//Feign will automatically handle loadbalancing
/*
	@Autowired
	private LoadBalancerClient loadBalancer;
	
	public String getProducerUri() {
		ServiceInstance serviceInstance=loadBalancer.choose(Constants.PRODUCER_APP_NAME);
		String baseUrl=serviceInstance.getUri().toString();		
		return baseUrl;
	}*/
}
