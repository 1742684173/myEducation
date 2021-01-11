package com.aloogn.api.enums;

/**
 * Created by zouXiaoLong on 2021/1/10 11:28
 */
public enum SEX {
    MALE("M","男"),
    FEMALE("F","女");

    private String code;
    private String desc;

    SEX(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
