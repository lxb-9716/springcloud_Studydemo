package com.it.springcloud.eurekaClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient   //表示该服务是eureka的客户端
@EnableFeignClients  //feign远程调用
@SpringBootApplication  //当前类是springBoot的启动类
public class EurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
        System.out.println("eurekaClient客户端启动成功");
    }
}
