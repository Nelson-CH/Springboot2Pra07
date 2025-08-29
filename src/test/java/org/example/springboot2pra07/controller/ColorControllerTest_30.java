package org.example.springboot2pra07.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@AutoConfigureMockMvc
public class ColorControllerTest_30 {

    private Logger logger = LoggerFactory.getLogger(ColorControllerTest_30.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getColor() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getColor30")).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        logger.info("返回结果信息：{}", result);
    }

    @Test
    void postColor() throws Exception {
        String webColor = "{\"webColor\":\"#f0f7ff\"}";
        mockMvc.perform(
                MockMvcRequestBuilders.post("/postColor30").param("webColor", webColor)
        );
    }

}
