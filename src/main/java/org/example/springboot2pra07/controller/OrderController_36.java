package org.example.springboot2pra07.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.springboot2pra07.entity.Order_36;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController_36 {

    @PostMapping("/buy36")
    public void buy(@Valid Order_36 order, BindingResult result) {
        log.info("请求order信息：{}", order);

        if (result.hasErrors()) {
            result.getAllErrors().forEach((error) -> {
                log.info(error.getCode() + "-" + error.getDefaultMessage());
            });
        }
    }

}
