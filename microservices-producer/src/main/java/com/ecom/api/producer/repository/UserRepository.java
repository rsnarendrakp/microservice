package com.ecom.api.producer.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.api.producer.domain.User;

@Repository
public interface UserRepository extends JpaRepository < User, Integer > {
    
}