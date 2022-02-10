package com.slokam.oauth;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<UserDetailsImpl, Integer>{

	public List<UserDetailsImpl> findByUsername(String username);
	
	@Query("select a from UserDetailsImpl u join u.authority a where u.username=?1 ")
	public List<GrantedAuthorityImpl> getRolesByUsername(String username);
	
}
