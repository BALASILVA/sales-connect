package com.orgin.sales.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.orgin.sales.model.User;

public class JwtUserFactory {

	public JwtUserFactory() {
		// TODO Auto-generated constructor stub
	}

	public static JwtUser create(User user) {	
		if( user.getEmail()!=null)
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), user,
				maptoGenerateAuthorities(new ArrayList<String>(Arrays.asList("ROLE_"+user.getRole()))),
				user.isEnable());
		else
		return new JwtUser(user.getId(), user.getPhoneNumber(), user.getPassword(), user,
				maptoGenerateAuthorities(new ArrayList<String>(Arrays.asList("ROLE_"+user.getRole()))),
				user.isEnable());
	}

	private static List<GrantedAuthority> maptoGenerateAuthorities(List<String> authorities) {
		// TODO Auto-generated method stub
		return authorities.stream().map(Authority -> new SimpleGrantedAuthority(Authority))
				.collect(Collectors.toList());
	}

}
