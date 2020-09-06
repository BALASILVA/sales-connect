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
public class EmailOtpController {
    
	@Autowired 
	OtpService OtpGeneratorService;
	 
	@PostMapping(value = "/otpmail")
    public ResponseEntity<Response> sendOtp(@RequestBody User user)
    {
		OtpGeneratorService.sendEmailOtp(user);
        return null;
    }
}
