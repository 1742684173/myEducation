package com.aloogn.project.enums;

/**
 * Created by zouXiaoLong on 2021/1/15 11:28
 * 学位(00-小学 10-初中 20-高中 30-大学 40-研究生 50-硕士 60-博士 99-其它)
 */
public enum DEGREE {

    PRIMARY("00","小学"),
    MIDDLE("10","初中"),
    HIGH("20","高中"),
    BK("30","本科"),
    YJS("40","研究生"),
    SS("50","硕士"),
    BS("60","博士"),
    OTHER("99","其它");

    private String code;
    private String name;

    DEGREE(String code, String name) {
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
