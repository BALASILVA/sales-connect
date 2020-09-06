package com.orgin.sales.service;

import java.util.List;

import com.orgin.sales.model.User;

public interface UserService {

	User save(User user);

	List<User> findAllByAdminId(long adminId);
  
	User getUserByEmail(String email);

    boolean checkPhoneExist(String phoneNUmber);

	boolean checkEmailExist(String email);

}
