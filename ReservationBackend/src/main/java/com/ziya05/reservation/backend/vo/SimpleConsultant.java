package com.ziya05.reservation.backend.vo;

import java.util.List;

import javax.persistence.Id;

public class SimpleConsultant {
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
     * 擅长方向，多个以半角逗号分隔
     */
    private List<String> goodAt;

    /**
     * 年龄
     */
    private int age;
    
    /**
     * 是否可约， 0: 本周可约, 1：下周可约, 2: 近期可约, 3： 近期不可约
     */
    private int booked;

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
     * 获取性别
     *
     * @return gender
     */
    public Boolean getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    /**
     * 获取擅长方向
     *
     * @return good_at - 擅长方向
     */
    public List<String> getGoodAt() {
        return goodAt;
    }

    /**
     * 设置擅长方向
     *
     * @param goodAt 擅长方向
     */
    public void setGoodAt(List<String> goodAt) {
        this.goodAt = goodAt;
    }

    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public int getBooked() {
		return booked;
	}

	public void setBooked(int booked) {
		this.booked = booked;
	}
    
}
