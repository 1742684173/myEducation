package com.aloogn.project.entity;

import java.util.Date;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-01-22 19:08:30
 */
@JsonIgnoreProperties({"createTime","updateTime"})
public class User implements Serializable {
    private static final long serialVersionUID = 168296129532091866L;
    
    private String id;
    /**
    * 名称
    */
    private String name;
    /**
    * 昵称
    */
    private String nikename;
    /**
    * 性别: 1-男 2-女
    */
    private Object sex;
    /**
    * 出生日期(YYYY-MM-DD)
    */
    private String birth;
    /**
    * 手机号
    */
    private String tel;
    /**
    * qq
    */
    private String qq;
    /**
    * 微信
    */
    private String wechat;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 学位(00-小学 10-初中 20-高中 30-大学 40-研究生 50-硕士 60-博士 99-其它)
    */
    private Object degree;
    /**
    * 密码
    */
    private String password;
    /**
    * 状态(00-正式、10-试用、20-实习、99-离职)
    */
    private Object status;
    /**
    * 身份证
    */
    private String idCard;
    /**
    * 登录id
    */
    private String loginId;
    /**
    * 角色id
    */
    private String roleId;
    /**
    * 地址id
    */
    private String addressId;
    /**
    * 民族id
    */
    private String nationId;
    /**
    * 国家id
    */
    private String countryId;
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public Object getSex() {
        return sex;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getDegree() {
        return degree;
    }

    public void setDegree(Object degree) {
        this.degree = degree;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getNationId() {
        return nationId;
    }

    public void setNationId(String nationId) {
        this.nationId = nationId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
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

}