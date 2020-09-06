package com.orgin.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orgin.sales.model.User;
import com.orgin.sales.service.UserService;

@RestController
public class UserContoller {
    @Autowired
	private UserService userService;
    
    @PostMapping(value = "/user")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUserByAdmin(@RequestBody User user)
    {
    	List<User> users = userService.findAllByAdminId(user.getAdminId());
    	System.out.println(users);
    	return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }

    /*
    @PostMapping(value = "/getuser")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<User>> getAllUserByEmployee()
    {
    	List<User> users = userService.findAll();
    	return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }
    */
    
    @GetMapping(value = "/checkforphone") 
    public boolean checkPhoneExist(@RequestParam("phone") String phoneNumber)
    {
    	System.out.println(phoneNumber);
    	boolean res = userService.checkPhoneExist(phoneNumber);
    	System.out.println(res);
    	return res;
    }
    @GetMapping(value = "/checkforemail") 
    public boolean checkemailExist(@RequestParam("email") String email)
    {
    	System.out.println(email);
    	boolean res = userService.checkEmailExist(email);
    	System.out.println(res);
    	return res;
    }
}
