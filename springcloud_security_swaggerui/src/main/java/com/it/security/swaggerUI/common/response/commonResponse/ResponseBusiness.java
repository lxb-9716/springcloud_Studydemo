package com.it.security.swaggerUI.common.response.commonResponse;

import com.it.security.swaggerUI.common.response.commonResponse.basic.ResponseBody;
import com.it.security.swaggerUI.common.response.commonResponse.basicRes.ResponseHeader;

public class ResponseBusiness<T, V> extends ResponseResult {

    //响应体
    private ResponseBody<T> responseBody;
    //响应头信息
    private ResponseHeader<V> responseHeader;

    public ResponseHeader<V> getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader<V> responseHeader) {
        this.responseHeader = responseHeader;
    }

    public ResponseBody<T> getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(ResponseBody<T> responseBody) {
        this.responseBody = responseBody;
    }
}
