package com.slokam.oauth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserDetailsController {

	@Autowired
	private UserDetailsServiceImpl service;
	
	@Autowired
	private AuthoritiesServiceImpl authservice;
	
	@RequestMapping("register")
	@PostMapping
	private ResponseEntity<String> registerUserDetails(@RequestBody UserDetailsImpl userDetailsImpl) {
	System.out.println("in Controller registerUserDetails");
		service.registerUserDetails(userDetailsImpl);
		
	return new ResponseEntity<String>("Registered Succesfully",HttpStatus.CREATED);
	}

	@RequestMapping("getAuthorities")
	@GetMapping
	private ResponseEntity<List<GrantedAuthorityImpl>> getAuthorities() {
	System.out.println("in Controller getAuthorities");
	List<GrantedAuthorityImpl> authorityImpls=authservice.getAuthorities();
		
	return new ResponseEntity<List<GrantedAuthorityImpl>>(authorityImpls,HttpStatus.CREATED);
	}
	
}
