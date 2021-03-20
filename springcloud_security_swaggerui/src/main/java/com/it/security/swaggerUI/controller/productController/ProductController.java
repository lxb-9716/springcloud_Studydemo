package com.it.security.swaggerUI.controller.productController;

import com.it.security.swaggerUI.api.product.ProductApi;
import com.it.security.swaggerUI.common.request.ReqBody;
import com.it.security.swaggerUI.common.request.RequestBussiness;
import com.it.security.swaggerUI.common.response.commonResponse.*;
import com.it.security.swaggerUI.common.response.commonResponse.basic.RespBody;
import com.it.security.swaggerUI.common.response.commonResponse.basicRes.CommonCode;
import com.it.security.swaggerUI.pojo.product.Product;
import com.it.security.swaggerUI.service.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*@Api(tags = "product商品相关接口")*/
@RestController
@RequestMapping("/product")
public class ProductController implements ProductApi {

    @Autowired
    private ProductService productService;

    /*保存商品用户信息*/
    @PostMapping(value = "/save", produces = "application/json;charset=UTF-8")
    /*@ApiOperation(value = "添加商品信息")*/
    public ResponseResult save(@RequestBody RequestBussiness<Product> requestBussiness) {
        ReqBody<Product> requestBody = requestBussiness.getRequestBody();
        Product data = requestBody.getData();
        Product product = productService.save(data);
        ResponseResult responseResult = new ResponseResult();
        if (null != product) {
            responseResult.setCode(CommonCode.SUCCESS.code());
            responseResult.setMessage(CommonCode.SUCCESS.message());
        } else {
            responseResult.setCode(CommonCode.FAIL.code());
            responseResult.setMessage(CommonCode.FAIL.message());
        }
        return responseResult;
    }

    /*根据id删除商品信息*/
    @GetMapping(value = "/deleteProductById/{id}", produces = "application/json;charset=UTF-8")
    @Override
    /*    @ApiOperation(value = "根据id删除商品信息")*/
    public ResponseResult deleteProductById(@PathVariable(value = "id", required = true) Integer id) {
        productService.deleteProductById(id);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    /*查询所有商品的信息,带分页*/
    @GetMapping("/findAllProductPage/{page}/{size}")
    @Override
    public ResponseBusinessPage<Product> findAllProductPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        if (page <= 0) {
            page = 0;
        }
        if (page >= 1) {
            page = page - 1;
        }
        if (size <= 0) {
            size = 5;
        }
        return productService.findAllProductPage(page, size);
    }

    /*根据商品id查询商品信息*/
    @Override
    @GetMapping(value = "/findProductById/{id}", produces = "application/json;charset=UTF-8")
    public ResponseBusiness<Product> findProductById(@PathVariable("id") Integer id) {
        Product product = productService.findProductById(id);
        ResponseBusiness<Product> responseBusiness = new ResponseBusiness<>();
        RespBody<Product> responseBody = new RespBody<>();
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        if (null != product) {
            responseBody.setData(productList);
            responseBusiness.setResponseBody(responseBody);
            responseBusiness.setCode(CommonCode.SUCCESS.code());
            responseBusiness.setMessage(CommonCode.SUCCESS.message());
        } else {
            responseBusiness.setCode(CommonCode.FAIL.code());
            responseBusiness.setMessage(CommonCode.FAIL.message());
        }
        return responseBusiness;
    }

}
