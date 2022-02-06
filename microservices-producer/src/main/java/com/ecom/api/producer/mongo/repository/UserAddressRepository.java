package com.ecom.api.producer.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecom.api.producer.domain.UserAddress;

/*
 * MongoRepository is @NoRepositoryBean bean
 * so adding @Repository will through exception
 */
public interface UserAddressRepository extends MongoRepository<UserAddress, Integer>{

}
