package com.org.house.service;

import com.google.common.collect.ImmutableList;
import com.org.house.entity.User;
import com.org.house.repository.UserRepository;
import com.org.house.role.Role;
import lombok.extern.log4j.Log4j2;
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
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User addUser(String email, String password, String firstName, String lastName, String username) {
        User newUser = User.builder()
                .username(username)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(encoder.encode(password))
                .date(new Date())
                .authorities(ImmutableList.of(Role.USER))
                .isAccountNonLocked(true)
                .isAccountNonExpired(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .build();

        log.debug("User was created");
        return userRepository.save(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(@NotNull String username) throws UsernameNotFoundException {
        log.debug("user: " + username + " was found");
        return userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(username)
        );
    }
}
