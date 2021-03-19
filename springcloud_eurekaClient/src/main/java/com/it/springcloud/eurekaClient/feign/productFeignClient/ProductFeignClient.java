package com.it.springcloud.eurekaClient.feign.productFeignClient;

import com.it.springcloud.eurekaClient.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "spring-cloud-security-swaggerui")
@RequestMapping("/product")
public interface ProductFeignClient {
    /*添加商品信息*/
    @PostMapping(value = "/save")
    public Product save(@RequestBody Product product);

    /*根据id删除商品信息*/
    @GetMapping("/deleteProductById/{id}")
    public String deleteProductById(@PathVariable(value = "id", required = true) Integer id);
}
