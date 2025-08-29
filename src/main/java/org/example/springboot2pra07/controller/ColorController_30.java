package org.example.springboot2pra07.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.example.springboot2pra07.entity.ColorDetail_30;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorController_30 {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/getColor30")
    public ColorDetail_30 getColor() {

        ColorDetail_30 colorDetail = new ColorDetail_30();
        colorDetail.setRed(0.94D);
        colorDetail.setGreen(0.97D);
        colorDetail.setBlue(1.0D);

        return colorDetail;
    }

    @PostMapping("/postColor30")
    public void postColor(String webColor) throws JsonProcessingException {

        ColorDetail_30 detail = objectMapper.readValue(webColor, ColorDetail_30.class);

        System.out.println("red:" + detail.getRed());
        System.out.println("green:" + detail.getGreen());
        System.out.println("blue:" + detail.getBlue());
    }

}
