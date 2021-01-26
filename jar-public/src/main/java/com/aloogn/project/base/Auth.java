package com.aloogn.project.base;

import lombok.Data;

/**
 * Created by zouXiaoLong on 2021/1/17 12:43
 */
@Data
public class Auth<T> extends BasePo{
    private String loginId;

    private T data;
}
