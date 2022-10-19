package com.springsecurity.service;

import com.springsecurity.model.Client_1;
import com.springsecurity.model.CustomerUserDetails_2;
import com.springsecurity.repository.UserSecurityRepository_3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerServiceDetails_4 implements UserDetailsService {

    @Autowired
    UserSecurityRepository_3 userSecurityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      Optional<Client_1> user = userSecurityRepository.findByClientUsername(username);

      user.orElseThrow( () -> new UsernameNotFoundException("Not Found " + username));
        return user.map(CustomerUserDetails_2::new).get();
    }
}
