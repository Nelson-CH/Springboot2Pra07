package org.example.springboot2pra07.config;

import org.example.springboot2pra07.json.Base64MappingJackson2HttpMessageConverter_34;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class JsonWebMvcConfigurer_34 implements WebMvcConfigurer {

    //自定義 base64 處理的 HttpMessageConverter
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        /*
        converters.clear() 這個操作通常不建議使用, 為什麼有人會使用 clear()？
        1. 完全控制轉換器
        目的：確保只有自定義的轉換器會被使用，避免預設轉換器干擾。
        2. 特殊的安全需求
        某些場景下，可能希望所有的 API 回應都必須經過 Base64 編碼，不允許返回普通的 JSON。

        使用 clear() 的問題:
        會失去的預設轉換器：
        Spring Boot 預設包含這些轉換器：
        - ByteArrayHttpMessageConverter        // 處理 byte[]
        - StringHttpMessageConverter           // 處理 String
        - ResourceHttpMessageConverter         // 處理檔案資源
        - SourceHttpMessageConverter          // 處理 XML Source
        - FormHttpMessageConverter            // 處理表單資料
        - MappingJackson2HttpMessageConverter // 處理 JSON
        - Jaxb2RootElementHttpMessageConverter // 處理 XML (如果有 JAXB)

        // ❌ 這個會失敗 - 沒有 StringHttpMessageConverter
        @GetMapping("/text")
        public String getText() {
            return "Hello World";
        }

        // ❌ 這個會失敗 - 沒有 ByteArrayHttpMessageConverter
        @GetMapping("/file")
        public byte[] getFile() {
            return fileBytes;
        }

        // ✅ 只有這個能工作 - 因為只有 Base64 轉換器
        @GetMapping("/user")
        public User getUser() {
            return new User();
        }
        */
        //converters.clear();
        //更好的替代方案
        // 不清除，添加到第一位，優先級最高
        converters.add(0, new Base64MappingJackson2HttpMessageConverter_34());
    }
}
