package com.it.springcloud.eurekaClient.controller;

import com.it.springcloud.eurekaClient.common.request.RequestBussiness;
import com.it.springcloud.eurekaClient.common.response.commonResponse.ResponseBusiness;
import com.it.springcloud.eurekaClient.common.response.commonResponse.ResponseBusinessPage;
import com.it.springcloud.eurekaClient.common.response.commonResponse.ResponseResult;
import com.it.springcloud.eurekaClient.feign.productFeignClient.ProductFeignClient;
import com.it.springcloud.eurekaClient.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productFeignClient")
public class ProductFeignClientController {

    @Autowired
    private ProductFeignClient productFeignClient;

    /*保存商品用户信息*/
    @PostMapping(value = "/save", produces = "application/json;charset=UTF-8")
    public ResponseResult save(@RequestBody RequestBussiness<Product> requestBussiness) {
        return productFeignClient.save(requestBussiness);
    }

    /*根据id删除商品信息*/
    @GetMapping(value = "/deleteProductById/{id}", produces = "application/json;charset=UTF-8")
    public ResponseResult deleteProductById(@PathVariable(value = "id", required = true) Integer id) {
        return productFeignClient.deleteProductById(id);
    }

    /*查询所有商品的信息,带分页*/
    @GetMapping("/findAllProductPage/{page}/{size}")
    public ResponseBusinessPage<Page<Product>> findAllProductPage(@PathVariable(value = "page", required = true) int page, @PathVariable(value = "size", required = true) int size) {
        return productFeignClient.findAllProductPage(page, size);
    }

}
