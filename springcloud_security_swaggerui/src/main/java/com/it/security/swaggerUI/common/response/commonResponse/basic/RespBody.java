package com.it.security.swaggerUI.common.response.commonResponse.basic;

import com.it.security.swaggerUI.page.productPage.ProductPage;

import java.util.List;

public class RespBody<T> {
    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public RespBody() {
    }
}
