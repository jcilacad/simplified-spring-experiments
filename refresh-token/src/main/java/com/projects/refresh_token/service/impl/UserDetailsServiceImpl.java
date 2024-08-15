package com.projects.refresh_token.service.impl;

import com.projects.refresh_token.security.CustomUserDetails;
import com.projects.refresh_token.entity.User;
import com.projects.refresh_token.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("Entering in loadUserByUsername method");
        User user = userRepository.findByUsername(username).get();
        if (user == null) {
            log.error("Username not found: {}", username);
            throw new UsernameNotFoundException(String.format("Username not found: %s", username));
        }

        log.info("User authenticated successfully");
        return new CustomUserDetails(user);
    }
}
