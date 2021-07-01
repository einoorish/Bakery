package com.example.bakery.service;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.bakery.domain.User;
import com.example.bakery.domain.security.UserRole;
import com.example.bakery.repos.RoleRepository;
import com.example.bakery.repos.UserRepository;

public class UserService {

	private static final Logger Log = Logger.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	public User createUser(User user, Set<UserRole> userRoles) {
		User localUser = userRepository.findByUsername(user.getUsername());
		
		if(localUser != null) {
			Log.info("User already exist");
		} else {
			for (UserRole ur : userRoles) 
				roleRepository.save(ur.getRole());
			
			user.getUserRoles().addAll(userRoles);
			localUser = userRepository.save(user);
		}
		
		return localUser;
	}
}
