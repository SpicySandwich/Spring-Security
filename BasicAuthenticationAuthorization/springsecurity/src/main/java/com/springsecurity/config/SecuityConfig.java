package com.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SecuityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
       List<UserDetails> user = Arrays.asList(
               User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build(),
               User.withDefaultPasswordEncoder()
                       .username("admin")
                       .password("password")
                       .roles("ADMIN")
                       .build()
       );
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/user").hasRole("USER")
                .antMatchers("/user").hasAnyRole("USER","ADMIN")
                //  .hasAnyRole()
                .and().formLogin();

        return http.build();
    }


}
