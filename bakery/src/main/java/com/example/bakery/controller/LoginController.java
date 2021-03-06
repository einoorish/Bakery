package com.example.bakery.controller;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bakery.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/token")
	public Map<String, String> token(HttpSession session, HttpServletRequest request) {
		return Collections.singletonMap("token", session.getId());
	}
	
	@RequestMapping("/checkSession")
	public ResponseEntity checkSession() {
		return new ResponseEntity("Session is active", HttpStatus.OK);
	}

	@RequestMapping(value="/logOut", method=RequestMethod.POST)
	public ResponseEntity logout() {
		SecurityContextHolder.clearContext();
		return new ResponseEntity("Logged out", HttpStatus.OK);
	}
}
