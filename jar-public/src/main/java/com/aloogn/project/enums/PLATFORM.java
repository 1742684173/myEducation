package com.aloogn.project.enums;

/**
 * Created by zouXiaoLong on 2021/1/19 22:30
 */
public enum PLATFORM {
    WEB("00","web"),
    ANDROID("10","android"),
    IOS("20","ios"),
    WECHAT("30","wechat"),
    OTHER("99","other");

    private String code;
    private String name;

    PLATFORM(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String CODE() {
        return code;
    }

    public String NAME() {
        return name;
    }
}
