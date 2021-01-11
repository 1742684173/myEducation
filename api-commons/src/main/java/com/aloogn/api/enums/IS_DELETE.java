package com.aloogn.api.enums;

/**
 * Created by zouXiaoLong on 2021/1/10 11:32
 */
public enum IS_DELETE {
    TRUE("T","true"),
    FALSE("F","false"),
    ;

    private String code;
    private String desc;

    IS_DELETE(String code, String desc) {
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
