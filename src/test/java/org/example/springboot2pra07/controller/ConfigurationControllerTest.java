package org.example.springboot2pra07.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
/*
@AutoConfigureMockMvc:
自動設定 MockMvc，讓你可以在測試中用它來模擬 HTTP 請求，測試 Spring MVC 的 Controller, 並且能注入 MockMvc
*/
@AutoConfigureMockMvc
public class ConfigurationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ConfigurationRemote"));
    }

    @Test
    void getUser() throws Exception {
        /*
        在 application.yml 中有設定這節要用的 user, 但是 application.properties 中有設定優先使用
        application-prod 設定檔, application-prod 設定檔有設定 user 相關參數但沒有 firstName 參數,
        firstName 參數是用 yml 的.
        */
        mockMvc.perform(MockMvcRequestBuilders.get("/ConfigurationUser"));
    }

}
