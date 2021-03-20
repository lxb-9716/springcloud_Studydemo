package com.it.security.swaggerUI.common.request;

public class ReqBody<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
