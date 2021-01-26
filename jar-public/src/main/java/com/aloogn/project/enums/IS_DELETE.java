package com.aloogn.project.enums;

/**
 * Created by zouXiaoLong on 2021/1/10 11:32
 */
public enum IS_DELETE {
    TRUE("T","true"),
    FALSE("F","false");

    private String code;
    private String name;

    IS_DELETE(String code, String name) {
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
