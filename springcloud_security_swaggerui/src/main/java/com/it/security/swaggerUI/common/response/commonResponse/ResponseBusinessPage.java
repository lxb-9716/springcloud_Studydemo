package com.it.security.swaggerUI.common.response.commonResponse;

import com.it.security.swaggerUI.common.response.commonResponse.basic.ResponseBodyPage;

public class ResponseBusinessPage<T> extends ResponseResult{

    public ResponseBusinessPage() {
    }

    private ResponseBodyPage<T> responseBodyPage;

    public ResponseBodyPage<T> getResponseBodyPage() {
        return responseBodyPage;
    }

    public void setResponseBodyPage(ResponseBodyPage<T> responseBodyPage) {
        this.responseBodyPage = responseBodyPage;
    }
}
