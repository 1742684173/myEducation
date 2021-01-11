package com.aloogn.door.common.exception;

import com.aloogn.door.common.response.ResultCode;

/**
 * Created by zouXiaoLong on 2020/12/28 15:46
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 4152637544358905017L;
    private Integer code;
    private String message;

    public BaseException(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public BaseException(ResultCode resultCode) {
        super();
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
