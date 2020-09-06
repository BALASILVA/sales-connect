package com.orgin.sales.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orgin.sales.UnauthorizedException;
import com.orgin.sales.domain.UserDTO;
import com.orgin.sales.model.User;
import com.orgin.sales.security.JwtTokenUtil;
import com.orgin.sales.security.JwtUser;
import com.orgin.sales.validator.UserDetailValidation;

@RestController
public class AuthenticationController {

	@Value("${jwt.header}")
	private String tokenHeader;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UserDetailValidation userDetailValidation;

	@PostMapping(value = "/login")
	public ResponseEntity<UserDTO> login(@RequestBody User user, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (user.getEmail() != null && user.getPassword() != null) {
				if (userDetailValidation.validateEmail(user.getEmail())
						&& userDetailValidation.vaildatePassword(user.getPassword())) {
					System.out.println("inside");
					Authentication authentication = authenticationManager
							.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
					System.out.println(user.getEmail() + " login  " + user.getPassword());
					final JwtUser userDetails = (JwtUser) authentication.getPrincipal();
					SecurityContextHolder.getContext().setAuthentication(authentication);
					final String token = jwtTokenUtil.generateToken(userDetails);
					response.setHeader("token", token);
					return new ResponseEntity<UserDTO>(new UserDTO(userDetails.getUser(), token), HttpStatus.OK);
				} else {
					throw new Exception("Invalid username or password");
				}
			} else {
				throw new Exception("Username or Password can't be empty");
			}
		} catch (Exception e) {
			if (e.getMessage().equalsIgnoreCase("Bad credentials")) {
				throw new UnauthorizedException("Username or Password dosn't match");
			}
			throw new UnauthorizedException(e.getMessage());
		}
	}

	@PostMapping(value = "/loginbyphonenumber")
	public ResponseEntity<UserDTO> loginByPhone(@RequestBody User user, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (user.getPhoneNumber() != null && user.getPassword() != null) {
				if (userDetailValidation.validatePhoneNumber(user.getPhoneNumber())
						&& userDetailValidation.vaildatePassword(user.getPassword())) {
					Authentication authentication = authenticationManager.authenticate(
							new UsernamePasswordAuthenticationToken(user.getPhoneNumber(), user.getPassword()));
					System.out.println(user.getEmail() + " login  " + user.getPassword());
					final JwtUser userDetails = (JwtUser) authentication.getPrincipal();
					SecurityContextHolder.getContext().setAuthentication(authentication);
					final String token = jwtTokenUtil.generateToken(userDetails);
					response.setHeader("token", token);
					return new ResponseEntity<UserDTO>(new UserDTO(userDetails.getUser(), token), HttpStatus.OK);
				} else {
					throw new Exception("Invalid Phonenumber or Password");
				}
			} else {
				throw new Exception("Phonenumber or Password can't be empty");
			}
		} catch (Exception e) {
			if (e.getMessage().equalsIgnoreCase("Bad credentials")) {
				throw new UnauthorizedException("Username or Password dosnt match");
			}
			throw new UnauthorizedException(e.getMessage());
		}
	}
}
