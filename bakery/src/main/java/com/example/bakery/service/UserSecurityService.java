package com.example.bakery.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.bakery.domain.User;
import com.example.bakery.repos.UserRepository;

@Service
public class UserSecurityService implements UserDetailsService{

	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if(user != null)
			return user;
	
		throw new UsernameNotFoundException("User \""+username+"\" not found");
	}

}
