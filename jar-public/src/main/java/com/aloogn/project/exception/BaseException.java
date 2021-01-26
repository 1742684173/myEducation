package com.aloogn.project.exception;

import com.aloogn.project.response.ResultCode;

/**
 * Created by zouXiaoLong on 2020/12/28 15:46
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 4152637544358905017L;
    private Integer code;
    private String message;

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseException(ResultCode resultCode,String...msg) {
        this(resultCode.getCode(),msg.length>0?msg[0]:resultCode.getMessage());
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
