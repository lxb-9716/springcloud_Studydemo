package com.it.security.swaggerUI.service.productService.imp;

import com.it.security.swaggerUI.common.response.commonResponse.ResponseBusinessPage;
import com.it.security.swaggerUI.page.productPage.ProductPage;
import com.it.security.swaggerUI.common.response.commonResponse.ResponseBusiness;
import com.it.security.swaggerUI.common.response.commonResponse.basic.ResponseBodyPage;
import com.it.security.swaggerUI.common.response.commonResponse.basicRes.CommonCode;
import com.it.security.swaggerUI.pojo.product.Product;
import com.it.security.swaggerUI.repository.productRepository.ProductRepository;
import com.it.security.swaggerUI.service.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    /*保存商品信息*/
    public Product save(Product product) {
        /*注意：当插入的该条数据主键已经存在的时候，会执行更新操作*/
        return productRepository.save(product);
    }

    @Override
    /*根据id删除商品信息*/
    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    /*查询所有商品的信息,带分页*/
    @Override
    public ResponseBusinessPage<Product> findAllProductPage(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        Page<Product> productPage = productRepository.findAll(pageable);
        ProductPage<Product> productProductPage = new ProductPage<>();
        ResponseBusinessPage<Product> responseBusinessPage = new ResponseBusinessPage<>();
        if (null != productPage) {
            productProductPage.setPage(page + 1);//jpa的分页默认是从0开始的，这里加1，表示第一页
            productProductPage.setSize(size);
            productProductPage.setTotalPage(productPage.getTotalPages());
            productProductPage.setTotalSize(productPage.getTotalElements());
            if (null != productPage.getContent() && productPage.getContent().size() > 0) {
                ResponseBodyPage<Product> responseBody = new ResponseBodyPage<>();
                responseBody.setData(productPage.getContent());
                responseBody.setProductPage(productProductPage);
                responseBusinessPage.setResponseBodyPage(responseBody);
                responseBusinessPage.setCode(CommonCode.SUCCESS.code());
                responseBusinessPage.setMessage(CommonCode.SUCCESS.message());
            } else {
                responseBusinessPage.setCode(CommonCode.FAIL.code());
                responseBusinessPage.setMessage(CommonCode.FAIL.message());
            }
        }
        return responseBusinessPage;
    }

    /*根据商品id查询商品信息*/
    @Override
    public Product findProductById(Integer id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = null;
        if (optional.isPresent()) {
            product = optional.get();
        }
        return product;
    }
}
