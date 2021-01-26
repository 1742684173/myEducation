package com.aloogn.project.response;

/**
 * Created by zouXiaoLong on 2020/12/28 20:58
 */
public class ErrorResult<T> {
    private Integer code;
    private String message;
    private T data;

    public static ErrorResult fail(ResultCode resultCode,Throwable e){
        ErrorResult errorResult = new ErrorResult();
        errorResult.setResultCode(resultCode);
//        errorResult.setData(e);
        return errorResult;
    }

    public static ErrorResult fail(Integer code, String message){
        ErrorResult errorResult = new ErrorResult();
        errorResult.setCode(code);
        errorResult.setMessage(message);
        return errorResult;
    }

    public void setResultCode(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
