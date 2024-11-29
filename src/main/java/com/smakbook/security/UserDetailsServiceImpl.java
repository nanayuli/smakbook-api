package com.smakbook.security;

import com.smakbook.model.User;
import com.smakbook.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project smakbook-api
 * @class UserDetailsServiceImpl
 * @since 28/11/2024 — 22.35
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User with login " + username + " was not found"));
        return UserDetailsImpl.build(user);
    }
}
