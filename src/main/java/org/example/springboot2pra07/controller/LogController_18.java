package org.example.springboot2pra07.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController_18 {

    private Logger logger = LogManager.getLogger(LogController_18.class);

    @GetMapping("/logtest")
    public void logtest() {
        logger.debug("debug日誌");
        logger.info("info日誌");
    }

}
