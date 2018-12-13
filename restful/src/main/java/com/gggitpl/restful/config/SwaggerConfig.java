package com.gggitpl.restful.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author wsj
 * 2018\12\12 0012
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("屋兰官网API接口文档")
                        .description("屋兰官网API接口说明文档")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gggitpl.restful.rest"))
                .paths(PathSelectors.any())
                .build();
    }

}
