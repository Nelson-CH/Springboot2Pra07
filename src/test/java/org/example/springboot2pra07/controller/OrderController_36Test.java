package org.example.springboot2pra07.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class OrderController_36Test {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void buy() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/buy36")
                        .param("requestNo", "")
                        .param("amount", "0")
                        .param("phone", "11111111111")
        );
    }
}
