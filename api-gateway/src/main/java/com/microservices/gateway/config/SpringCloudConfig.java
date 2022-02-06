package com.microservices.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author Narendra
 *  so each request should go through this app host and port 
 *  e.g. http://localhost:8762/api_v1/consumer/message
 *
 */
@Configuration
public class SpringCloudConfig {

	/*
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes().route("auth", r -> r.path("/auth/**").filters(f -> f.filter(filter)).uri("lb://auth"))
				.route("alert", r -> r.path("/alert/**").filters(f -> f.filter(filter)).uri("lb://alert"))
				.route("echo", r -> r.path("/echo/**").filters(f -> f.filter(filter)).uri("lb://echo"))
				.route("hello", r -> r.path("/hello/**").filters(f -> f.filter(filter)).uri("lb://hello")).build();
	}
*/
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
       /* return builder.routes()
                .route(r -> r.path("/api_v1/**")
                        .uri("http://localhost:9083/"))
                       // .id("restservice"))

               // .route(r -> r.path("/consumer/**")
                    //    .uri("http://localhost:8082/"))
                        //.id("consumerModule"))
                .build(); */
       
        return builder.routes()
				.route(r -> r.path("/api_v1/employee/**")
				//Pre and Post Filters provided by Spring Cloud Gateway
						.filters(f -> f.addRequestHeader("first-request", "first-request-header")
								.addResponseHeader("first-response", "first-response-header"))
						.uri("http://localhost:9083/"))
						//.id("employeeModule"))

				.route(r -> r.path("/api_v1/consumer/**")
				//Pre and Post Filters provided by Spring Cloud Gateway
						.filters(f -> f.addRequestHeader("second-request", "second-request-header")
								.addResponseHeader("second-response", "second-response-header"))
						.uri("http://localhost:9083/"))
						//.id("consumerModule"))
				.build();
    }
/*
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/employee/**")
                        .uri("lb://FIRST-SERVICE")
                        .id("employeeModule"))

                .route(r -> r.path("/consumer/**")
                        .uri("lb://SECOND-SERVICE")
                        .id("consumerModule"))
                .build();
    }*/
}
