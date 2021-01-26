package com.aloogn.project.base;

import lombok.Data;

/**
 * Created by zouXiaoLong on 2021/1/16 16:41
 */
@Data
public class BasePo {
    private String token;
    private String transCode;
    private String operate;
    private String platform;
    private String time;
    private String userId;

}
