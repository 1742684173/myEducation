package com.aloogn.project.enums;

/**
 * Created by zouXiaoLong on 2021/1/10 11:37
 * 00-正式、10-试用、20-实习、-离职
 */
public enum USER_STATUS {
    FORMAL("00","正式"),
    TRY("10","试用"),
    PRACTICE("20","实习"),
    LEAVA("99","离职");

    private String code;
    private String name;

    USER_STATUS(String code, String name) {
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
