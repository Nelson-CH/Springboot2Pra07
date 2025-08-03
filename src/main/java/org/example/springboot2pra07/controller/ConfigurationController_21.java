package org.example.springboot2pra07.controller;

import jakarta.annotation.Resource;
import org.example.springboot2pra07.bean.RemoteConfig_21;
import org.example.springboot2pra07.bean.User_21;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationController_21 {

    @Resource
    private RemoteConfig_21 remoteConfig;

    @Resource
    private User_21 user;

    @GetMapping("/ConfigurationRemote")
    public void getInfo() {
        System.out.println("地址：" + remoteConfig.getAddress());
        System.out.println("端口：" + remoteConfig.getPort());
        System.out.println("電話:" + remoteConfig.getPhone());
        System.out.println("用戶名:" + remoteConfig.getUser().getUsername());
    }

    @GetMapping("/ConfigurationUser")
    public void getUser(){
        System.out.println("用户名：" + user.getUsername());
        System.out.println("密码：" + user.getPassword());
        System.out.println("姓名：" + user.getFirstName());
    }
}