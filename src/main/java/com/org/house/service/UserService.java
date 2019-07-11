package com.org.house.service;

import com.google.common.collect.ImmutableList;
import com.org.house.DTO.UserDTO;
import com.org.house.entity.User;
import com.org.house.repository.UserRepository;
import com.org.house.role.Role;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Log4j2
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    private ModelMapper modelMapper = new ModelMapper();
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User addUser(UserDTO userDTO) {
        log.info("User was created");

        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        userDTO.setAuthorities(ImmutableList.of(Role.USER));
        userDTO.setDate(new Date());
        userDTO.setAccountNonExpired(true);
        userDTO.setAccountNonLocked(true);
        userDTO.setCredentialsNonExpired(true);
        userDTO.setEnabled(true);

        return userRepository.save(modelMapper.map(userDTO, User.class));
    }

    @Override
    public UserDetails loadUserByUsername(@NotNull String username) throws UsernameNotFoundException {
        log.info("user: " + username + " was found");
        return userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(username)
        );
    }
}
