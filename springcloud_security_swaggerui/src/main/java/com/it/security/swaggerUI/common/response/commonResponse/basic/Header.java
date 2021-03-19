package com.it.security.swaggerUI.common.response.commonResponse.basic;

import com.netflix.client.http.HttpResponse;

public class Header {
    private HttpResponse response;

    public HttpResponse getResponse() {
        return response;
    }

    public void setResponse(HttpResponse response) {
        this.response = response;
    }

}
