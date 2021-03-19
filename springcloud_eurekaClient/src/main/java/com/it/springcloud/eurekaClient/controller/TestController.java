package com.it.springcloud.eurekaClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private FeignApiClient feignApiClient;

    @GetMapping("/feignRpcTest.json")
    public String feignRpcTest() {
        //feign远程调用spring-cloud-security-swaggerui服务中的test接口方法
        String test = feignApiClient.test();
        return "feign远程成功调用spring-cloud-security-swaggerui服务中的test接口方法，返回的内容如下：" + test;
    }
}
