package org.example.springboot2pra07.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController_16 {

    @Value("${user.username}")
    private String username;
    @Value("${user.phone}")
    private String phone;

    @GetMapping("/userInfo")
    public String getInfo(){
        return "username: " + username + ", phone: " + phone;
    }
}
