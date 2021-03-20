package com.it.security.swaggerUI.service.productService;


import com.it.security.swaggerUI.common.response.commonResponse.ResponseBusiness;
import com.it.security.swaggerUI.common.response.commonResponse.ResponseBusinessPage;
import com.it.security.swaggerUI.pojo.product.Product;

public interface ProductService {
    /*保存商品信息*/
    public Product save(Product product);

    /*根据id删除商品信息*/
    public void deleteProductById(Integer id);

    /*查询所有商品的信息,带分页*/
    public ResponseBusinessPage<Product> findAllProductPage(int page, int size);

    /*根据商品id查询商品信息*/
    public Product findProductById(Integer id);
}
