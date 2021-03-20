package com.it.security.swaggerUI.common.request;


public class RequestBussiness<T> {
    private ReqBody<T> requestBody;

    public ReqBody<T> getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(ReqBody<T> requestBody) {
        this.requestBody = requestBody;
    }
}
