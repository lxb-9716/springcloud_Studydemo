package com.it.springcloud.eurekaClient.feign.productFeignClient;

import com.it.springcloud.eurekaClient.common.request.RequestBussiness;
import com.it.springcloud.eurekaClient.common.response.commonResponse.ResponseBusiness;
import com.it.springcloud.eurekaClient.common.response.commonResponse.ResponseBusinessPage;
import com.it.springcloud.eurekaClient.common.response.commonResponse.ResponseResult;
import com.it.springcloud.eurekaClient.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "spring-cloud-security-swaggerui")
@RequestMapping("/product")
public interface ProductFeignClient {
    /*保存商品用户信息*/
    @PostMapping(value = "/save", produces = "application/json;charset=UTF-8")
    public ResponseResult save(@RequestBody RequestBussiness<Product> requestBussiness);

    /*根据id删除商品信息*/
    @GetMapping(value = "/deleteProductById/{id}", produces = "application/json;charset=UTF-8")
    public ResponseResult deleteProductById(@PathVariable(value = "id", required = true) Integer id);


    /*查询所有商品的信息,带分页*/
    @GetMapping("/findAllProductPage/{page}/{size}")
    public ResponseBusinessPage<Page<Product>> findAllProductPage(@PathVariable(value = "page", required = true) int page, @PathVariable(value = "size", required = true) int size);

}
