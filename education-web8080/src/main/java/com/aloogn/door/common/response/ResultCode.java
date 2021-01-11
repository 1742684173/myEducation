package com.aloogn.door.common.response;

public enum ResultCode {
    SUCCESS(1,"成功"),
    FAIL(-1,"其它错误"),

    SYSTEM_ERROR(10000,"系统异常"),
    CLASS_LOADER_ERROR(10050,"类加载错误"),

    /*参数错误：10001-19999*/
    PARAM_NOT_NULL(10001,"参数不能为空"),
    PARAM_IS_INVALID(10005,"参数无效"),
    PARAM_TRANSCODE_NOT_NULL(10010,"交易码不能为空"),
    UNAUTHORIZED(10401,"签名验证错误"),

    /*用户错误：20001-29999*/
    USER_HAS_EXISTED(20001,"用户名已存在"),
    USER_NOT_FIND(20002,"用户名不存在");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
