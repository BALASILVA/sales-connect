package com.orgin.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orgin.sales.domain.Response;
import com.orgin.sales.model.User;
import com.orgin.sales.service.OtpService;

@RestController
public class SmsOptController {
     
	 @Autowired 
	 OtpService OtpGeneratorService;
	 
	 @PostMapping(value = "/optsms")
     public ResponseEntity<Response> sendOtp(@RequestBody User user)
     {
		  OtpGeneratorService.sendSmsOtp(user);
		  return null;
     }
}
