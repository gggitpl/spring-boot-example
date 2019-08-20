package com.gggitpl.upload;

import com.gggitpl.upload.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(FileStorageProperties.class)
@SpringBootApplication
public class SpringbootUploadApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootUploadApplication.class, args);
  }

}
