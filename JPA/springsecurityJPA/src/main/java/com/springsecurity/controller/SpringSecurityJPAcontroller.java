package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityJPAcontroller {

    @GetMapping("/")
    public String welcome(){
        return "Welcome to spring security";
    }
    @GetMapping("/user")
    public String user(){
        return "Welcome user";
    }
    @GetMapping("/admin")
    public String admin(){
        return "Welcome admin";
    }

}
