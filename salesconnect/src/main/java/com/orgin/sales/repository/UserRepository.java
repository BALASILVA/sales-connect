package com.orgin.sales.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.orgin.sales.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	User findByEmailIgnoreCase(String username);

	User findByPhoneNumberIgnoreCase (String username);

	List<User> findAllByAdminId(long adminId);
	
}
