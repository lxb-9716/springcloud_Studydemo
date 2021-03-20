package com.it.security.swaggerUI.common.response.commonResponse.basic;

import com.it.security.swaggerUI.page.productPage.ProductPage;

public class ResponseBodyPage<T> extends RespBody {
    public ProductPage<T> getProductPage() {
        return productPage;
    }

    public void setProductPage(ProductPage<T> productPage) {
        this.productPage = productPage;
    }

    private ProductPage<T> productPage;

}
