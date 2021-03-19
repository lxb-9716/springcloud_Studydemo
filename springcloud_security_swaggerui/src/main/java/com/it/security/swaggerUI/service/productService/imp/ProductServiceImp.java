package com.it.security.swaggerUI.service.productService.imp;

import com.it.security.swaggerUI.pojo.product.Product;
import com.it.security.swaggerUI.repository.productRepository.ProductRepository;
import com.it.security.swaggerUI.service.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    /*保存商品信息*/
    public Product save(Product product) {
        /*注意：当插入的该条数据主键已经存在的时候，会执行更新操作*/
        Product save = productRepository.save(product);
        return save;
    }

    @Override
    /*根据id删除商品信息*/
    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    /*查询所有商品的信息,不带分页*/
    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    /*查询所有商品的信息,带分页*/
    @Override
    public Page<Product> findAllProductPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

}
