package com.it.springcloud.eurekaClient.common.request;

import java.io.Serializable;

public class ReqBody<T> implements Serializable {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
