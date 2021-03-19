package com.it.security.swaggerUI.common.response.commonResponse.basicRes;

public class ResponseHeader<T> {
    //响应头
    private T header;

    public T getResponseHeader() {
        return header;
    }

    public void setResponseHeader(T header) {
        this.header = header;
    }
}
