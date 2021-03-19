package com.it.security.swaggerUI.service.productService;

import com.it.security.swaggerUI.pojo.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    /*保存商品信息*/
    public Product save(Product product);

    /*根据id删除商品信息*/
    public void deleteProductById(Integer id);

    /*查询所有商品的信息,不带分页*/
    public List<Product> findAllProduct();

    /*查询所有商品的信息,带分页*/
    public Page<Product> findAllProductPage(Pageable pageable);
}
