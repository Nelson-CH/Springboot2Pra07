package org.example.springboot2pra07.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.springboot2pra07.entity.Order_29;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PostMapping;


@SpringBootTest
@AutoConfigureMockMvc
public class OrderController_29Test {

    private Logger logger = LoggerFactory.getLogger(OrderController_29Test.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getOrderInfo() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getOrderInfo29")).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        logger.info("返回结果信息：{}", result);
    }

    @Test
    void addOrder() throws Exception {
        String order = "{\"orderNo\":\"NO1000\",\"amount\":124.00}";

        mockMvc.perform(
                MockMvcRequestBuilders.post("/addOrder29").param("orderJson", order)
        );
    }

}
