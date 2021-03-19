package com.it.security.swaggerUI.common.response.commonResponse.basic;

import java.util.List;

public class ResponseBody<T> {
    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
