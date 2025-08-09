package org.example.springboot2pra07.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DbServiceTest_22 {

    @Autowired
    private DbService_22 service;

    @Test
    void getDbInfo(){
        service.getDbInfo();
    }
}
