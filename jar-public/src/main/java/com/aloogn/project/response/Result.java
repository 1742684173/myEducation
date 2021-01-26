package com.aloogn.project.response;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by zouXiaoLong on 2020/12/28 20:58
 */
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static Result success(Object data,String... message){
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        if(message.length > 0){
            result.setMessage(message[0]);
        }else{
            result.setMessage(ResultCode.SUCCESS.getMessage());
        }
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result fail(ResultCode resultCode,String... message){
        Result result = new Result();
        result.setCode(resultCode.getCode());
        if(message.length > 0){
            result.setMessage(message[0]);
        }else{
            result.setMessage(resultCode.getMessage());
        }
        return result;
    }

    private void setResultCode(ResultCode resultCode) {
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
