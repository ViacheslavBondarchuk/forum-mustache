package com.org.house.service;

import java.util.Collections;
import java.util.Date;

import org.apache.catalina.webresources.FileResourceSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.org.house.entity.User;
import com.org.house.repository.UserRepository;
import com.org.house.role.Role;

import lombok.extern.log4j.Log4j2;	

@Log4j2
@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
//	@Autowired
//	private BCryptPasswordEncoder encoder;
	
	public User addUser(String email, String password, String firstName, String lastName, String username) {
		User newUser = User.builder()
				.username(username)
				.firstName(firstName)
				.lastName(lastName)
				.email(email)
				.password(password)
				.date(new Date())
				.authorities(ImmutableList.of(Role.USER))
				.isAccountNonLocked(true)
				.isAccountNonExpired(true)
				.isCredentialsNonExpired(true)
				.isEnabled(true)
				.build();
		
		log.info("User was created");
		return userRepository.save(newUser);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return  User.builder()
				.username("user")
				.firstName("Viacheslav")
				.lastName("Bondarchuk")
				.email("bondarchuk@outlook.com")
				.password("password")
				.date(new Date())
				.authorities(ImmutableList.of(Role.ADMIN))
				.isAccountNonLocked(true)
				.isAccountNonExpired(true)
				.isCredentialsNonExpired(true)
				.isEnabled(true)
				.build();
	}
}
