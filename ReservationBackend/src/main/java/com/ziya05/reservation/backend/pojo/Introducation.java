package com.ziya05.reservation.backend.pojo;

import javax.persistence.*;

public class Introducation {
    /**
     * 简介id, 主键标识
     */
    @Id
    private String id;

    /**
     * 图片地址
     */
    private String img;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 权重， 权重高的排前
     */
    private Integer weight;

    /**
     * 获取简介id, 主键标识
     *
     * @return id - 简介id, 主键标识
     */
    public String getId() {
        return id;
    }

    /**
     * 设置简介id, 主键标识
     *
     * @param id 简介id, 主键标识
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取图片地址
     *
     * @return img - 图片地址
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置图片地址
     *
     * @param img 图片地址
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取描述信息
     *
     * @return description - 描述信息
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述信息
     *
     * @param description 描述信息
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取权重， 权重高的排前
     *
     * @return weight - 权重， 权重高的排前
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置权重， 权重高的排前
     *
     * @param weight 权重， 权重高的排前
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}