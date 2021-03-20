package com.it.springcloud.eurekaClient.common.response.commonResponse;

public interface ResultCode {
    /* 000000-成功   111111-失败*/
    final static String CODE = "000000";
    final static String MESSAGE = "成功";

    //操作代码
    String code();

    //提示信息
    String message();

}
