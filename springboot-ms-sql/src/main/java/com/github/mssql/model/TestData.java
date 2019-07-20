package com.github.mssql.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/7/19 17:29
 * @Created by windows
 */
@Entity
@Table(name = "Test_Data")
public class TestData {
    private Integer id;

    private String stationCode;

    private Date timePoint;

    private String detectionItemCode;

    private String datakey;

    private String monValue;

    private String mark;

    private Date updateTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "stationcode", nullable = false)
    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    @Column(name = "timepoint", nullable = false)
    public Date getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(Date timePoint) {
        this.timePoint = timePoint;
    }

    @Column(name = "detectionitemcode", nullable = false)
    public String getDetectionItemCode() {
        return detectionItemCode;
    }

    public void setDetectionItemCode(String detectionItemCode) {
        this.detectionItemCode = detectionItemCode;
    }

    @Column(name = "datakey", nullable = false)
    public String getDatakey() {
        return datakey;
    }

    public void setDatakey(String datakey) {
        this.datakey = datakey;
    }

    @Column(name = "monvalue", nullable = false)
    public String getMonValue() {
        return monValue;
    }

    public void setMonValue(String monValue) {
        this.monValue = monValue;
    }

    @Column(name = "mark")
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Column(name = "updatetime", nullable = false)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}