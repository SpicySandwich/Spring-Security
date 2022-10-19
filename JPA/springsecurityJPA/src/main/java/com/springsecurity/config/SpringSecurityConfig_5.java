package com.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig_5 {


    @Bean
    public UserDetailsService users(AuthenticationManagerBuilder auth,UserDetailsService userDetailsService) throws Exception {
        UserDetailsService users = auth.userDetailsService(userDetailsService).getUserDetailsService();
        return users;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .antMatchers("/h2/**").permitAll() //h2 set up to open
                .antMatchers("/").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER", "ADMIN")
                .and().formLogin();
//        http.csrf().disable(); //h2 set up to open
//        http.headers().frameOptions().disable(); //h2 set up to open
        return http.build();
    }
}
