package org.example.springboot2pra07.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParamController_14 {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/param")
    public String param() {

        String systemServerPort = System.getProperty("server.port");

        System.out.println("@value 獲得的 serverPort: " + serverPort);
        System.out.println("System 的 serverPort: " + systemServerPort);

        return  "sucess";
    }
}
