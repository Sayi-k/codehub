package com.security.spring.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.spring.jpa.User;
import com.security.spring.jpa.UserRepository;

@Service
public class MyUseDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optional = userRepository.findByUserName(username);
		optional.orElseThrow(() -> new UsernameNotFoundException("User name not found: "+username));
		return optional.map(MyUserDetails::new).get();
	}

}
