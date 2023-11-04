package com.adrian.memberapi.service.implementation;

import com.adrian.memberapi.model.UserCredentials;
import com.adrian.memberapi.repository.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    public UserDetailsServiceImpl(UserCredentialsRepository userCredentialsRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials userCredentials = userCredentialsRepository.findByUsername(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(userCredentials.getRole().toString());
        return new org.springframework.security.core.userdetails.User(
                userCredentials.getUsername(),
                userCredentials.getPassword(),
                Collections.singletonList(authority)
        );
    }
}
