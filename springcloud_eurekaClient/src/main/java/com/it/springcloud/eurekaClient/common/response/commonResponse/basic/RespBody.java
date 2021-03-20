package com.it.springcloud.eurekaClient.common.response.commonResponse.basic;

import com.it.springcloud.eurekaClient.page.productPage.ProductPage;

import java.util.List;

public class RespBody<T> {
    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public RespBody() {
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
