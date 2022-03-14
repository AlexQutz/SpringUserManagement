package com.example.demo.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface MyUserDetailsService extends UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
