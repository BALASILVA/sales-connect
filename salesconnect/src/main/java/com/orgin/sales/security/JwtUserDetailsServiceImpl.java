package com.orgin.sales.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.orgin.sales.repository.UserRepository;
import com.orgin.sales.model.User;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{
 
	@Autowired 
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmailIgnoreCase(username);
		if(user == null)
		{
			user=userRepository.findByPhoneNumberIgnoreCase(username);
		}
		if(user == null)
		{
			throw new UsernameNotFoundException(String.format("NO User found with username" , username));
		}
		else
		{
			return JwtUserFactory.create(user);
		}
	}
}
