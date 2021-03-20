package com.it.springcloud.eurekaClient.common.response.commonResponse.basic;

import com.it.springcloud.eurekaClient.page.productPage.ProductPage;

public class ResponseBodyPage<T> extends RespBody {

    public ResponseBodyPage() {
    }

    public ProductPage<T> getProductPage() {
        return productPage;
    }

    public void setProductPage(ProductPage<T> productPage) {
        this.productPage = productPage;
    }

    private ProductPage<T> productPage;

}
