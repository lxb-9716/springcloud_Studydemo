package com.it.security.swaggerUI.api.product;


import com.it.security.swaggerUI.common.request.RequestBussiness;
import com.it.security.swaggerUI.common.response.commonResponse.ResponseBusiness;
import com.it.security.swaggerUI.common.response.commonResponse.ResponseBusinessPage;
import com.it.security.swaggerUI.common.response.commonResponse.ResponseResult;
import com.it.security.swaggerUI.pojo.product.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "商品信息管理接口", description = "商品信息的增加、删除、修改、查询")
public interface ProductApi {
    /*保存商品信息*/
    @ApiOperation("保存商品信息")
    public ResponseResult save(RequestBussiness<Product> requestBussiness);

    /*根据id删除商品信息*/
    @ApiOperation("根据id删除商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品主键id", required = true,
                    paramType = "path", dataType = "int"),
    })
    public ResponseResult deleteProductById(Integer id);

    /*查询所有商品的信息,带分页*/
    @ApiOperation("查询所有商品的信息,带分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true,
                    paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true,
                    paramType = "path", dataType = "int")
    })
    public ResponseBusinessPage<Product> findAllProductPage(int page, int size);

    /*根据商品id查询商品信息*/
    @ApiOperation("查询所有商品的信息,带分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "页码", required = true,
                    paramType = "path", dataType = "int")
    })
    public ResponseBusiness<Product> findProductById(Integer id);
}
