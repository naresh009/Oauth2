package com.slokam.oauth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//		UserDetailsImpl userDetailsImpl=new UserDetailsImpl();
//		
//		userDetailsImpl.setAccountNonExpired(true);
//		userDetailsImpl.setAccountNonLocked(true);
////		userDetailsImpl.setAuthority(authority);
//		userDetailsImpl.setCredentialsNonExpired(true);
//		userDetailsImpl.setEnabled(true);
//		userDetailsImpl.setUsername(username);  // for any username 
//		userDetailsImpl.setPassword("naresh123"); // setting password
//		
//		GrantedAuthorityImpl authority1=new GrantedAuthorityImpl();
//		authority1.setAuthority("MANAGER");
//		GrantedAuthorityImpl authority2=new GrantedAuthorityImpl();
//		authority2.setAuthority("ADMIN");
//		
//		Collection<GrantedAuthorityImpl> collection=new 
//		ArrayList<GrantedAuthorityImpl>();
//		collection.add(authority1);
//		collection.add(authority2);
//		
//		userDetailsImpl.setAuthority(collection);
		
		List<UserDetailsImpl> user=userDao.findByUsername(username);
		
		if(user.size()==0) {
			throw new UsernameNotFoundException("Invalid Username");
		}

		UserDetailsImpl user1=user.get(0);
		
		List<GrantedAuthorityImpl> authorityImpls=userDao.getRolesByUsername(username);
		
		user1.setAuthority(authorityImpls);
		
		return user1;
//		return userDetailsImpl;
	}

	public void registerUserDetails(UserDetailsImpl userDetailsImpl) {
	userDao.save(userDetailsImpl);
	
	}

}
