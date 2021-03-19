package com.it.security.swaggerUI.controller.productController;

import com.it.security.swaggerUI.api.product.ProductApi;
import com.it.security.swaggerUI.common.response.commonResponse.*;
import com.it.security.swaggerUI.common.response.commonResponse.basic.Header;
import com.it.security.swaggerUI.common.response.commonResponse.basic.ResponseBody;
import com.it.security.swaggerUI.common.response.commonResponse.basicRes.CommonCode;
import com.it.security.swaggerUI.pojo.product.Product;
import com.it.security.swaggerUI.service.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
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
    public ResponseBusiness<Product, Header> save(@RequestBody Product product) {
        Product save = productService.save(product);
        ResponseBusiness<Product, Header> responseBusiness = new ResponseBusiness<>();
        ResponseBody<Product> responseBody = new ResponseBody<>();
        List<Product> products = new ArrayList<>();
        if (null != product) {
            products.add(save);
            responseBody.setData(products);
            responseBusiness.setResponseBody(responseBody);
            responseBusiness.setCode(CommonCode.SUCCESS.code());
            responseBusiness.setMessage(CommonCode.SUCCESS.message());
        }
        return responseBusiness;
    }

    /*根据id删除商品信息*/
    @GetMapping(value = "/deleteProductById/{id}", produces = "application/json;charset=UTF-8")
    @Override
    /*    @ApiOperation(value = "根据id删除商品信息")*/
    public ResponseResult deleteProductById(@PathVariable(value = "id", required = true) Integer id) {
        productService.deleteProductById(id);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    /*查询所有商品的信息,不带分页*/
    @Override
    @GetMapping(value = "/findAllProduct", produces = "application/json")
    /*@ApiOperation(value = "查询所有商品的信息,无分页")*/
    public ResponseBusiness<Product, Header> findAllProduct() {
        List<Product> productList = productService.findAllProduct();
        ResponseBusiness<Product, Header> responseBusiness = new ResponseBusiness<Product, Header>();
        if (null != productList && productList.size() > 0) {
            ResponseBody<Product> responseBody = new ResponseBody<>();
            responseBody.setData(productList);
            responseBusiness.setResponseBody(responseBody);
            responseBusiness.setCode(CommonCode.SUCCESS.code());
            responseBusiness.setMessage(CommonCode.SUCCESS.message());
        }
        return responseBusiness;
    }

    /*查询所有商品的信息,带分页*/
    @Override
    @GetMapping("/findAllProductPage/{page}/{size}/{sortByCollection}")
    /*@ApiOperation(value = "查询所有商品的信息,带分页")*/
    public ResponseBusiness<Page<Product>, Header> findAllProductPage(@PathVariable(value = "page", required = true) int page, @PathVariable(value = "size", required = true) int size, @PathVariable(value = "sortByCollection") String sortByCollection) {
        if (page <= 0) {
            page = 0;
        }
        if (size <= 0) {
            size = 5;
        }
        if (StringUtils.isEmpty(sortByCollection)) {
            //如果排序的条件值为空，设置默认根据id进行排序
            sortByCollection = "id";
        }
        //查询结果根据id进行升序排序展示
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, sortByCollection);
        Page<Product> productPage = productService.findAllProductPage(pageable);
        List<Product> content = productPage.getContent();
        ResponseBusiness<Page<Product>, Header> responseBusiness = new ResponseBusiness();

        if (null != content) {
            ResponseBody<Page<Product>> responseBody = new ResponseBody<>();
            List<Page<Product>> pageProducts = new ArrayList<>();
            pageProducts.add(productPage);
            responseBody.setData(pageProducts);
            responseBusiness.setResponseBody(responseBody);
            responseBusiness.setCode(CommonCode.SUCCESS.code());
            responseBusiness.setMessage(CommonCode.SUCCESS.message());
        }
        return responseBusiness;
    }


}
