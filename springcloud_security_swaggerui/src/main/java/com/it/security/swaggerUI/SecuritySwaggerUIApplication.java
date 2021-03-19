package com.it.security.swaggerUI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
public class SecuritySwaggerUIApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecuritySwaggerUIApplication.class, args);
        System.out.println("springboot整合security、swagger-ui环境成功启动！！！");
    }
}
