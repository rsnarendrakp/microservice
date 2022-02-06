package com.microservices.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {
	final Logger logger =  LoggerFactory.getLogger(CustomFilter.class);
	public CustomFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		/*// Custom Pre Filter. Suppose we can extract JWT and perform Authentication
		return (exchange, chain) -> {
			System.out.println("First pre filter" + exchange.getRequest());
			// Custom Post Filter.Suppose we can call error response handler based on error
			// code.
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				System.out.println("First post filter");
			}));
		};*/
		return (exchange, chain) -> {
	        // Pre-processing
	        if (config.isPreLogger()) {
	            logger.info("Pre GatewayFilter logging: "
	              + config.getBaseMessage());
	        }
	        return chain.filter(exchange)
	          .then(Mono.fromRunnable(() -> {
	              // Post-processing
	              if (config.isPostLogger()) {
	                  logger.info("Post GatewayFilter logging: "
	                    + config.getBaseMessage());
	              }
	          }));
	    };
	}

	public static class Config {
		// Put the configuration properties
		private String baseMessage;
		private boolean preLogger;
		private boolean postLogger;

		public Config() {
			super();
		}

		public Config(String baseMessage, boolean preLogger, boolean postLogger) {
			super();
			this.baseMessage = baseMessage;
			this.preLogger = preLogger;
			this.postLogger = postLogger;
		}

		public String getBaseMessage() {
			return baseMessage;
		}

		public void setBaseMessage(String baseMessage) {
			this.baseMessage = baseMessage;
		}

		public boolean isPreLogger() {
			return preLogger;
		}

		public void setPreLogger(boolean preLogger) {
			this.preLogger = preLogger;
		}

		public boolean isPostLogger() {
			return postLogger;
		}

		public void setPostLogger(boolean postLogger) {
			this.postLogger = postLogger;
		}
	}
}
