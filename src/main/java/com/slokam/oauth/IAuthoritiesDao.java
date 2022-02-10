package com.slokam.oauth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthoritiesDao extends JpaRepository<GrantedAuthorityImpl, Integer>{

}
