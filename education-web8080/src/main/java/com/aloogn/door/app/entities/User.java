package com.aloogn.door.app.entities;

import lombok.Data;

/**
 * Created by zouXiaoLong on 2021/1/10 10:14
 */
@Data
public class User {
    private int id;
    private String loginId;
    private String name;
    private String sex;//enum SEX F-男 W-女
    private String email;
    private String password;
    private String status;//enum USER_STATUS
    private String isDelete;//enum IS_DELETE F-删除 T-正常
    private String createTime;
    private String updateTime;
    private String createUser;
    private String updateUser;
}
