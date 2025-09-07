package org.example.springboot2pra07.json;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
public class Base64MappingJackson2HttpMessageConverter_34 extends MappingJackson2HttpMessageConverter {
    @Override
    protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // 使用父類的 ObjectMapper
        String json = getObjectMapper().writeValueAsString(object);
        log.info(json);
        // Base64 編碼，明確指定 UTF-8 不要使用系統默認
        String base64Result = Base64.getEncoder().encodeToString(json.getBytes(StandardCharsets.UTF_8));
        log.info(base64Result);
        // 输出
        outputMessage.getBody().write(base64Result.getBytes(StandardCharsets.UTF_8));
    }
}
