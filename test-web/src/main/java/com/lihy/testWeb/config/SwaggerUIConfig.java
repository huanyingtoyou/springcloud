package com.lihy.testWeb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lihy
 * @date 2018/02/08
 */
@Configuration
//@ComponentScan(basePackages = { "com.lihy.*.controller.*" })
@EnableSwagger2
public class SwaggerUIConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                /*.paths(Predicates.or(
                        //这里添加需要展示的接口
                        *//*PathSelectors.ant("/account/**"),
                        PathSelectors.ant("/xxx/**"),
                        PathSelectors.ant("/qqq/**"),*//*
                        PathSelectors.ant("/hello/**")
                        )
                )*/
                .apis(RequestHandlerSelectors.basePackage("com.lihy.testWeb.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测试项目")
                .description("这里是api文档接口")
                .contact(new Contact("lihy", "url", "email"))
                .version("1.0")
                .build();
    }
}
