package com.it.security.swaggerUI.common.response.commonResponse.basicRes;

import com.it.security.swaggerUI.common.response.commonResponse.ResultCode;

public enum CommonCode implements ResultCode {
    SUCCESS("000000", "操作成功！"),
    FAIL("111111", "操作失败！");
    //操作代码
    String code;
    //提示信息
    String message;

    private CommonCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }


}
