package com.aloogn.project.enums;

/**
 * Created by zouXiaoLong on 2021/1/15 11:34
 */
public enum OPERATE {
    ADD("00","增加"),
    ADD_LIST("01","批量增加"),
    UPDATE("10","修改"),
    DELETE("20","删除"),
    QUERY("30","查询"),
    QUERY_ALL("31","根据条件查询所有");


    private String code;
    private String name;

    OPERATE(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String CODE() {
        return code;
    }

    public String NAME() {
        return name;
    }

    public static OPERATE getByCode(String code){
        if(code == null) return null;

        for (OPERATE enums :OPERATE.values()) {
            if (enums.CODE().equals(code)) {
                return enums;
            }
        }
        return null;
    }

    public static OPERATE getByName(String name){
        if(name == null) return null;

        for (OPERATE enums :OPERATE.values()) {
            if (enums.NAME().equals(name)) {
                return enums;
            }
        }
        return null;
    }
}
