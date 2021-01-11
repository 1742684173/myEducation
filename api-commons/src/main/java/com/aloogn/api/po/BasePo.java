package com.aloogn.api.po;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by zouXiaoLong on 2020/12/26 10:49
 */
@Data
public class BasePo implements Serializable {
    private String transcode;
    private String userId;
    private String time;


}
