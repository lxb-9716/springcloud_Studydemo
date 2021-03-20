package com.it.security.swaggerUI.common.response.commonResponse;

import com.it.security.swaggerUI.common.response.commonResponse.basic.RespBody;
import com.it.security.swaggerUI.common.response.commonResponse.basic.ResponseBodyPage;

public class ResponseBusiness<T> extends ResponseResult {

    public RespBody<T> getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(RespBody<T> responseBody) {
        this.responseBody = responseBody;
    }

    //响应体
    private RespBody<T> responseBody;

    public ResponseBusiness() {
    }
}
