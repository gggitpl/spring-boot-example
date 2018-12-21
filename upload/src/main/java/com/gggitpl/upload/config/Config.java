package com.gggitpl.upload.config;

import com.gggitpl.upload.properties.StorageProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import javax.servlet.MultipartConfigElement;

@Configuration
@EnableConfigurationProperties({StorageProperties.class})
public class Config {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.of(5, DataUnit.MEGABYTES)); //KB,MB
        factory.setMaxRequestSize(DataSize.of(15, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }

}
