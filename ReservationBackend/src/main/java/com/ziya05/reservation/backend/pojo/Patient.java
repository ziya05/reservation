package com.ziya05.reservation.backend.pojo;

import java.util.Date;
import javax.persistence.*;

public class Patient {
    /**
     * 患者id, 主键
     */
    @Id
    private String id;

    /**
     * 患者的openid
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * 患者昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 患者性别，0: 未知，1: 男， 2: 女
     */
    private Integer gender;

    /**
     * 患者出生日期
     */
    private Date birthday;

    /**
     * 患者手机号
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 患者头像地址
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 患者省份
     */
    private String province;

    /**
     * 患者城市
     */
    private String city;

    /**
     * 获取患者id, 主键
     *
     * @return id - 患者id, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置患者id, 主键
     *
     * @param id 患者id, 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取患者的openid
     *
     * @return open_id - 患者的openid
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置患者的openid
     *
     * @param openId 患者的openid
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取患者昵称
     *
     * @return nick_name - 患者昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置患者昵称
     *
     * @param nickName 患者昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取患者性别，0: 未知，1: 男， 2: 女
     *
     * @return gender - 患者性别，0: 未知，1: 男， 2: 女
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置患者性别，0: 未知，1: 男， 2: 女
     *
     * @param gender 患者性别，0: 未知，1: 男， 2: 女
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取患者出生日期
     *
     * @return birthday - 患者出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置患者出生日期
     *
     * @param birthday 患者出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取患者手机号
     *
     * @return phone_number - 患者手机号
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置患者手机号
     *
     * @param phoneNumber 患者手机号
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取患者头像地址
     *
     * @return avatar_url - 患者头像地址
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * 设置患者头像地址
     *
     * @param avatarUrl 患者头像地址
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * 获取患者省份
     *
     * @return province - 患者省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置患者省份
     *
     * @param province 患者省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取患者城市
     *
     * @return city - 患者城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置患者城市
     *
     * @param city 患者城市
     */
    public void setCity(String city) {
        this.city = city;
    }
}