package com.microservices.auth.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.microservices.auth.dto.CustomUserDetail;
import com.microservices.auth.dto.UserDto;

@Service
public class AppUserDetailsService implements UserDetailsService{

	@Autowired
	UserService userService;
	protected final transient Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto user=null;
		CustomUserDetail customUserDetail=new CustomUserDetail();
		try {
				user=userService.getUserByLoginId(username);
			String roles = user.getRole();
		    logger.debug("role of the user" + roles);
		    Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	        //for(Role role: roles){
	            authorities.add(new SimpleGrantedAuthority(user.getRole()));
	            logger.debug("role {}", user.getRole() );	            
	        //}
	    		
	            customUserDetail.setUser(user);
	            customUserDetail.setAuthorities(authorities);
		}catch(Exception e) {
			logger.error("Exception",e);
		}
        return customUserDetail;
	}

}
