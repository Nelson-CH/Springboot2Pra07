package org.example.springboot2pra07.controller;

import jakarta.annotation.Resource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArgumentsController {

    //通過 ApplicationArguments 介面獲取命令行傳遞的參數
    @Resource
    private ApplicationArguments applicationArguments;

    @GetMapping("/args")
    public String getArguments() {

        System.out.println("非選項參數數量" + applicationArguments.getNonOptionArgs().size());
        System.out.println("選項參數數量" + applicationArguments.getOptionNames().size());

        System.out.println("非選項參數");
        /*
        方法引用:
        這裡的 System.out::println 是 方法引用 (method reference)，它其實是 Lambda 表達式的簡寫形式，等同於
        arg -> System.out.println(arg)

        對於 getNonOptionArgs() 傳回的參數依序印出來。
        */
        applicationArguments.getNonOptionArgs().forEach(System.out::println);

        System.out.println("選項參數具體參數");
        /*
        使用 Lambda 表達式處理每個選項參數的名字.
        */
        applicationArguments.getOptionNames().forEach(optionName -> {
            System.out.println("--" + optionName + "m" + applicationArguments.getOptionValues(optionName));
        });

        return "success";
    }
}
