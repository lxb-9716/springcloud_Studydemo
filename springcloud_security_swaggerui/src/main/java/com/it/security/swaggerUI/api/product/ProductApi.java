package com.it.security.swaggerUI.api.product;


import com.it.security.swaggerUI.common.response.commonResponse.basic.Header;
import com.it.security.swaggerUI.common.response.commonResponse.ResponseBusiness;
import com.it.security.swaggerUI.common.response.commonResponse.ResponseResult;
import com.it.security.swaggerUI.pojo.product.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Api(value = "商品信息管理接口", description = "商品信息的增加、删除、修改、查询")
public interface ProductApi {
    /*保存商品信息*/
    @ApiOperation("保存商品信息")
    public ResponseBusiness<Product, Header> save(@RequestBody Product product);

    /*根据id删除商品信息*/
    @ApiOperation("根据id删除商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品主键id", required = true,
                    paramType = "path", dataType = "int"),
    })
    public ResponseResult deleteProductById(Integer id);

    /*查询所有商品的信息,不带分页*/
    @ApiOperation("查询所有商品的信息,不带分页")
    public ResponseBusiness<Product, Header> findAllProduct();

    /*查询所有商品的信息,带分页*/
    @ApiOperation("查询所有商品的信息,带分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true,
                    paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true,
                    paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "sortByCollection", value = "升/降序排序依据的字段", required = true,
                    paramType = "path", dataType = "String")
    })
    public ResponseBusiness<Page<Product>,Header> findAllProductPage(int page, int size, String sortByCollection);
}
