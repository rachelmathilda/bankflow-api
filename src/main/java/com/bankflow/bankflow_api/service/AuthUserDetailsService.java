package com.bankflow.bankflow_api.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.bankflow.bankflow_api.repository.AuthRepository;

import com.bankflow.bankflow_api.domain.Auth;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class AuthUserDetailsService implements UserDetailsService {
    private final AuthRepository authRepository;

    @Override 
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Auth auth = authRepository.findByUsername(username);
        if (auth == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return auth;
    }
}