package org.example.springboot2pra07.factory;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.lang.Nullable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
自定義了一個 YamlPropertyLoaderFactory，它繼承 DefaultPropertySourceFactory，目的是
讓 Spring Framework 的 @PropertySource 支援載入 .yml / .yaml 格式的配置文件，而不是只
能載入 .properties。
*/
public class YamlPropertyLoaderFactory extends DefaultPropertySourceFactory {

    /*
    EncodedResource resource: 傳入的 YAML 檔案資源。
    loadYamlIntoProperties(...): 將 YAML 內容轉為 Java 的 Properties。
    PropertiesPropertySource(...): 建立屬性來源，讓 Spring 能識別。
    */
    @Override
    public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource resource) throws IOException {
        Properties propertiesFromYaml = loadYamlIntoProperties(resource);
        String sourceName = name != null ? name : resource.getResource().getFilename();
        return new PropertiesPropertySource(sourceName, propertiesFromYaml);
    }

    /*
    這裡使用 YamlPropertiesFactoryBean：
    將 YAML 檔案轉成 Properties。
    若找不到檔案則轉為 FileNotFoundException。
    */
    private Properties loadYamlIntoProperties(EncodedResource resource) throws FileNotFoundException {
        try {
            YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
            factory.setResources(resource.getResource());
            factory.afterPropertiesSet();
            return factory.getObject();
        } catch (IllegalStateException e) {
            Throwable cause = e.getCause();
            if (cause instanceof FileNotFoundException) {
                throw (FileNotFoundException) e.getCause();
            }
            throw e;
        }
    }

}
