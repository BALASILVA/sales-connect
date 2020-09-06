package com.orgin.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orgin.sales.UnauthorizedException;
import com.orgin.sales.domain.Response;
import com.orgin.sales.model.User;
import com.orgin.sales.service.OtpService;
import com.orgin.sales.service.UserService;
import com.orgin.sales.validator.UserDetailValidation;

@RestController
public class PreLogInController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserDetailValidation userDetailValidation;
	@Autowired
	OtpService otpService;

	@PostMapping(value = "/registrationAdminbymail")
	public ResponseEntity<Response> registration(@RequestBody User user, @RequestParam("otp") String otp) {
		try {
			System.out.println(user);
			if (otpService.isValidOtpForMail(user, otp)) {
			if (userDetailValidation.valdateUserByEmail(user)) {
				user.setRole("ADMIN");
				user.setEnable(true);
				User dBuser = userService.save(user);
				if (dBuser != null) {
					return new ResponseEntity<Response>(new Response("OK"), HttpStatus.OK);
				} else {
					throw new UnauthorizedException("Something Went Wrong.. Please Try Again");
				}
			} else {
				throw new UnauthorizedException("Invalid User Details Check and Try again");
			}
			}
			else
			{
				throw new UnauthorizedException("OTP Is Not Valid");
			}
		} catch (Exception e) {
			throw new UnauthorizedException(e.getMessage());
		}

	}

	@PostMapping(value = "/registrationbyphone")
	public ResponseEntity<Response> registrationAdminByPhone(@RequestBody User user, @RequestParam("otp") String otp) {
		try {
			System.out.println(user);
			if (otpService.isValidOtpForPhoneNumber(user, otp)) {
				if (userDetailValidation.valdateUserByPhoneNumber(user)) {
					user.setRole("ADMIN");
					user.setEnable(true);
					User dBuser = userService.save(user);
					if (dBuser != null) {
						return new ResponseEntity<Response>(new Response("OK"), HttpStatus.OK);
					} else {
						throw new UnauthorizedException("Something Went Wrong.. Please Try Again");
					}
				} else {
					throw new UnauthorizedException("Invalid User Details Check and Try again");
				}
			} else {
				throw new UnauthorizedException("OTP NOT VALID");
			}
		} catch (Exception e) {
			throw new UnauthorizedException(e.getMessage());
		}
	}









	@PostMapping(value = "/registrationuserbymail")
    @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Response> registrationUserByMail(@RequestBody User user) {
		try {
			System.out.println(user);
			if (userDetailValidation.valdateUserByEmail(user)) {
				user.setRole("USER");
				user.setEnable(true);
				User dBuser = userService.save(user);
				if (dBuser != null) {
					return new ResponseEntity<Response>(new Response("OK"), HttpStatus.OK);
				} else {
					throw new UnauthorizedException("Something Went Wrong.. Please Try Again");
				}
			} else {
				throw new UnauthorizedException("Invalid User Details Check and Try again");
			}
		} catch (Exception e) {
			throw new UnauthorizedException(e.getMessage());
		}

	}

	@PostMapping(value = "/registrationuserbyphone")
    @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Response> registrationUserByPhone(@RequestBody User user) {
		try {
			System.out.println(user);
				if (userDetailValidation.valdateUserByPhoneNumber(user)) {					
					user.setRole("USER");
					user.setEnable(true);
					User dBuser = userService.save(user);
					if (dBuser != null) {
						return new ResponseEntity<Response>(new Response("OK"), HttpStatus.OK);
					} else {
						throw new UnauthorizedException("Something Went Wrong.. Please Try Again");
					}
				} else {
					throw new UnauthorizedException("Invalid User Details Check and Try again");
				}
		} catch (Exception e) {
			throw new UnauthorizedException(e.getMessage());
		}
	}
}
