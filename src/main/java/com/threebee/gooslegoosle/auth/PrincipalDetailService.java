package com.threebee.gooslegoosle.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.threebee.gooslegoosle.entity.UserEntity;
import com.threebee.gooslegoosle.repository.IUserRepository;



@Service 
public class PrincipalDetailService implements UserDetailsService{

	@Autowired
	private IUserRepository userRepository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity principal = userRepository.findbyUsername(username).orElseThrow(()->{
			return new UsernameNotFoundException("해당 유저를 찾을 수 없습니다. ");
		});
		return new PrincipalDetail(principal);
	}
	
	

}
