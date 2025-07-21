package org.example.springboot2pra07.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController_08 {

    /**
     * @apiNote GET http://localhost:8080/hello
     * @return {String} "Hello World!"
     */
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }
}
