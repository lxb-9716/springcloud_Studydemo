package com.it.security.swaggerUI.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "test模块包含的接口")
public class Test {

    @GetMapping("/")
    @ApiOperation(value = "test", notes = "测试")
    public String test() {
        return "测试成功！！！";
    }

    @GetMapping("/security")
    @ApiOperation(value = "security", notes = "security测试")
    public String security() {
        return "hello security！！！";
    }
}
