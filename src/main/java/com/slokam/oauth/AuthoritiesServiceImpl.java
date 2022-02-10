package com.slokam.oauth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesServiceImpl {

	@Autowired
	private IAuthoritiesDao service;

	public List<GrantedAuthorityImpl> getAuthorities() {
		List<GrantedAuthorityImpl> authorityImpls=service.findAll();
		return authorityImpls;
	}
	
	
}
