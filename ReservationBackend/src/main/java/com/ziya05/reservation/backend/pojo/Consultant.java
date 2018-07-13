package com.ziya05.reservation.backend.pojo;

import java.util.Date;
import javax.persistence.*;

public class Consultant {
    /**
     * 用户id, 主键标识
     */
    @Id
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 资质，多个以半角逗号分隔
     */
    private String qualification;

    /**
     * 性别， 0/false: 男, 1/true: 女
     */
    private Boolean gender;

    /**
     * 个人介绍
     */
    private String introducation;

    /**
     * 擅长方向，多个以半角逗号分隔
     */
    @Column(name = "good_at")
    private String goodAt;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 头像地址
     */
    private String profile;

    /**
     * 获取用户id, 主键标识
     *
     * @return id - 用户id, 主键标识
     */
    public String getId() {
        return id;
    }

    /**
     * 设置用户id, 主键标识
     *
     * @param id 用户id, 主键标识
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取资质，多个以半角逗号分隔
     *
     * @return qualification - 资质，多个以半角逗号分隔
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * 设置资质，多个以半角逗号分隔
     *
     * @param qualification 资质，多个以半角逗号分隔
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * 获取性别， 0/false: 男, 1/true: 女
     *
     * @return gender - 性别， 0/false: 男, 1/true: 女
     */
    public Boolean getGender() {
        return gender;
    }

    /**
     * 设置性别， 0/false: 男, 1/true: 女
     *
     * @param gender 性别， 0/false: 男, 1/true: 女
     */
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    /**
     * 获取个人介绍
     *
     * @return introducation - 个人介绍
     */
    public String getIntroducation() {
        return introducation;
    }

    /**
     * 设置个人介绍
     *
     * @param introducation 个人介绍
     */
    public void setIntroducation(String introducation) {
        this.introducation = introducation;
    }

    /**
     * 获取擅长方向，多个以半角逗号分隔
     *
     * @return good_at - 擅长方向，多个以半角逗号分隔
     */
    public String getGoodAt() {
        return goodAt;
    }

    /**
     * 设置擅长方向，多个以半角逗号分隔
     *
     * @param goodAt 擅长方向，多个以半角逗号分隔
     */
    public void setGoodAt(String goodAt) {
        this.goodAt = goodAt;
    }

    /**
     * 获取出生日期
     *
     * @return birthday - 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置出生日期
     *
     * @param birthday 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取头像地址
     *
     * @return profile - 头像地址
     */
    public String getProfile() {
        return profile;
    }

    /**
     * 设置头像地址
     *
     * @param profile 头像地址
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }
}