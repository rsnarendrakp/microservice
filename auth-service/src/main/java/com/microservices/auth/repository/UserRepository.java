package com.microservices.auth.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.auth.dto.UserDto;

@Repository
public interface UserRepository extends JpaRepository < UserDto, Integer > {

	UserDto findByLoginId(String loginId);

}