package com.microservices.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.microservices.auth.service.AppUserDetailsService;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AppUserDetailsService appUserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.httpBasic().and().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api_v1/**").hasRole("USER")
				.antMatchers(HttpMethod.POST, "/api_v1/**").hasRole("USER")
				.antMatchers(HttpMethod.PUT, "/api_v1/**").hasRole("USER")
				.antMatchers(HttpMethod.PATCH, "/api_v1/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api_v1/**").hasRole("ADMIN")
				.and().csrf().disable().formLogin()
				.disable();*/
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/api_v1/**").authenticated()
		.antMatchers(HttpMethod.PUT, "/api_v1/**")
		.authenticated().antMatchers(HttpMethod.DELETE, "/api/**")
		.authenticated().anyRequest().permitAll()
		.and().httpBasic().and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	/*@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}*/
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
