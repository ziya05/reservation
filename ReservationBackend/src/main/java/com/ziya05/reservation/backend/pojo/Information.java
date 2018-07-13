package com.ziya05.reservation.backend.pojo;

import java.util.Date;
import javax.persistence.*;

public class Information {
    /**
     * 开放时段id, 主键标识 
     */
    @Id
    private String id;

    /**
     * 咨询师id
     */
    @Column(name = "consultant_id")
    private String consultantId;

    /**
     * 开发日期
     */
    @Column(name = "opening_date")
    private Date openingDate;

    /**
     * 开始时间
     */
    @Column(name = "begin_time")
    private Date beginTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 当年第几周
     */
    @Column(name = "week_of_year")
    private Integer weekOfYear;

    /**
     * 星期几
     */
    @Column(name = "day_of_week")
    private Integer dayOfWeek;

    /**
     * 患者id
     */
    @Column(name = "patient_id")
    private String patientId;

    /**
     * 是否删除， 没有患者预约过的， 数据将物理删除， 否则逻辑删除， 0/false: 未删除， 1/true: 已删除
     */
    private Boolean deleted;

    /**
     * 状态， 0: 未被预约， 1: 待进行， 2: 已完成, 3: 已关闭
     */
    private Integer status;

    /**
     * 获取开放时段id, 主键标识 
     *
     * @return id - 开放时段id, 主键标识 
     */
    public String getId() {
        return id;
    }

    /**
     * 设置开放时段id, 主键标识 
     *
     * @param id 开放时段id, 主键标识 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取咨询师id
     *
     * @return consultant_id - 咨询师id
     */
    public String getConsultantId() {
        return consultantId;
    }

    /**
     * 设置咨询师id
     *
     * @param consultantId 咨询师id
     */
    public void setConsultantId(String consultantId) {
        this.consultantId = consultantId;
    }

    /**
     * 获取开发日期
     *
     * @return opening_date - 开发日期
     */
    public Date getOpeningDate() {
        return openingDate;
    }

    /**
     * 设置开发日期
     *
     * @param openingDate 开发日期
     */
    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    /**
     * 获取开始时间
     *
     * @return begin_time - 开始时间
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * 设置开始时间
     *
     * @param beginTime 开始时间
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 获取结束时间
     *
     * @return end_time - 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取当年第几周
     *
     * @return week_of_year - 当年第几周
     */
    public Integer getWeekOfYear() {
        return weekOfYear;
    }

    /**
     * 设置当年第几周
     *
     * @param weekOfYear 当年第几周
     */
    public void setWeekOfYear(Integer weekOfYear) {
        this.weekOfYear = weekOfYear;
    }

    /**
     * 获取星期几
     *
     * @return day_of_week - 星期几
     */
    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * 设置星期几
     *
     * @param dayOfWeek 星期几
     */
    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    /**
     * 获取患者id
     *
     * @return patient_id - 患者id
     */
    public String getPatientId() {
        return patientId;
    }

    /**
     * 设置患者id
     *
     * @param patientId 患者id
     */
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    /**
     * 获取是否删除， 没有患者预约过的， 数据将物理删除， 否则逻辑删除， 0/false: 未删除， 1/true: 已删除
     *
     * @return deleted - 是否删除， 没有患者预约过的， 数据将物理删除， 否则逻辑删除， 0/false: 未删除， 1/true: 已删除
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * 设置是否删除， 没有患者预约过的， 数据将物理删除， 否则逻辑删除， 0/false: 未删除， 1/true: 已删除
     *
     * @param deleted 是否删除， 没有患者预约过的， 数据将物理删除， 否则逻辑删除， 0/false: 未删除， 1/true: 已删除
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取状态， 0: 未被预约， 1: 待进行， 2: 已完成, 3: 已关闭
     *
     * @return status - 状态， 0: 未被预约， 1: 待进行， 2: 已完成, 3: 已关闭
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态， 0: 未被预约， 1: 待进行， 2: 已完成, 3: 已关闭
     *
     * @param status 状态， 0: 未被预约， 1: 待进行， 2: 已完成, 3: 已关闭
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}