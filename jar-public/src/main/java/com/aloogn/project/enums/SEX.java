package com.aloogn.project.enums;

/**
 * Created by zouXiaoLong on 2021/1/10 11:28
 */
public enum SEX {
    MALE("M","男"),
    FEMALE("F","女");

    private String code;
    private String name;

    SEX(String code, String name) {
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
