package com.aloogn.project.doservice.queryProjectSort;


import com.aloogn.project.base.BasePo;
import lombok.Data;

/**
 * Created by zouXiaoLong on 2021/1/10 10:35
 */
@Data
public class Po extends BasePo {
    private String id;
    /**
     * 上一级目录
     */
    private String parentId;
    /**
     * 名称
     */
    private String name;
    /**
     * 序号
     */
    private String no;
}
