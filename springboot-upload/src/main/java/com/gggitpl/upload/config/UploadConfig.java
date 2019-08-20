package com.gggitpl.upload.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Slf4j
@Configuration
public class UploadConfig {

  //@Bean
  //public CommonsMultipartResolver multipartResolver() {
  //  CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
  //  multipartResolver.setMaxUploadSize(1000000000);
  //  multipartResolver.setDefaultEncoding("UTF-8");
  //  multipartResolver.getFileUpload().setProgressListener(
  //      (long pBytesRead, long pContentLength, int pItems) -> {
  //        log.debug("{}-{}-{}", pBytesRead, pContentLength, pItems);
  //      });
  //  return multipartResolver;
  //}

}
