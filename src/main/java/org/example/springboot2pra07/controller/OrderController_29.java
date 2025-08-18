package org.example.springboot2pra07.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.springboot2pra07.entity.Order_29;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class OrderController_29 {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping(value = "/getOrderInfo29", produces = "application/json;charset=UTF-8")
    public Order_29 getOrderInfo() {
        Order_29 order = new Order_29();
        order.setOrderNo("NO11111");
        order.setAmount(100.00);
        order.setType("VIP");
        return order;
    }

    @PostMapping("/addOrder29")
    public void addOrder(String orderJson) throws JsonProcessingException {
        //透過 objectMapper 讀取傳入的字符串, 並解析成 Order_29 物件
        Order_29 order = objectMapper.readValue(orderJson, Order_29.class);
        System.out.println("orderNo:" + order.getOrderNo());
        System.out.println("amount:" + order.getAmount());
    }
}
