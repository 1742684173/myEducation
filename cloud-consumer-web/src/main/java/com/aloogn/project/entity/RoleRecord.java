package com.aloogn.project.entity;

import java.util.Date;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * (RoleRecord)实体类
 *
 * @author makejava
 * @since 2021-01-22 19:09:06
 */
@JsonIgnoreProperties({"createTime","updateTime"})
public class RoleRecord implements Serializable {
    private static final long serialVersionUID = 940133564370157270L;
    
    private String id;
    
    private String parentId;
    /**
    * 名称
    */
    private String name;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 创建用户
    */
    private String createUser;
    /**
    * 更新用户
    */
    private String updateUser;
    
    private String rid;
    /**
    * 平台(00-web 10-android 20-ios 30-wechat 99-其它)
    */
    private Object platform;
    /**
    * 操作(20-删除 10-修改 00-增加)
    */
    private Object operate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public Object getPlatform() {
        return platform;
    }

    public void setPlatform(Object platform) {
        this.platform = platform;
    }

    public Object getOperate() {
        return operate;
    }

    public void setOperate(Object operate) {
        this.operate = operate;
    }

}