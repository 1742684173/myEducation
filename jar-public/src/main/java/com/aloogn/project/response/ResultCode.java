package com.aloogn.project.response;

import com.aloogn.project.enums.OPERATE;

public enum ResultCode {
    SUCCESS(1,"成功"),
    FAIL(-1,"其它错误"),

    DATA_INSERT_FAIL(444,"插入数据失败"),
    DATA_UPDATE_FAIL(445,"修改数据失败"),
    DATA_DELETE_FAIL(446,"删除数据失败"),

    SYSTEM_ERROR(10000,"系统异常"),
    MIC_SERVICE_ERROR(10001,"调用微服务系统异常"),
    CLASS_LOADER_ERROR(10050,"类加载错误"),

    /*参数错误：10001-19999*/
    PARAM_NOT_NULL(10001,"参数不能为空"),
    PARAM_OPERATE_NOT_NULL(10002,"操作标志不能为空"),
    PARAM_IS_INVALID(10005,"参数无效"),
    PARAM_TRANSCODE_NOT_NULL(10010,"交易码不能为空"),
    UNAUTHORIZED(10401,"验证错误"),
    SESSION_OVERTIME(10402,"会话过期"),

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

    public static ResultCode getByCode(Integer code){
        if(code == null) return null;

        for (ResultCode enums :ResultCode.values()) {
            if (enums.getCode().equals(code)) {
                return enums;
            }
        }
        return null;
    }


}
