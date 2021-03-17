package com.it.security.swaggerUI.config;

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

@Configuration
@EnableSwagger2
/*swagger的一些配置文件*/
public class Swagger2Config {
    /*可以配置swagger2的基本信息，指定扫描哪些包*/
    @Bean
    public Docket createRequestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.it.security.swaggerUI.api"))
                .paths(PathSelectors.any())
                .build();

    }

    /*该方法可以配置有关api文档描述的一些详细信息*/
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot整合swagger-ui")//文档名
                .contact(new Contact("lxb", null, "lxb_9716@163.com"))//创建人相关信息
                .description("springboot整合swagger-ui模块相关的api测试")//对于文档的一些描述性信息
                .version("1.0.1")//版本号
                .build();
    }

}
