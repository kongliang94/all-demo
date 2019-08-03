package com.superstation.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/7/31 13:39
 * @Created by windows
 */
@Data
@Entity
public class Air1m20191001B {
    /**
    * 
    */
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    /**
    * 站点code
    */
    private String stationCode;

    /**
    * 污染物code
    */
    private String detectionItemCode;

    /**
    * 时间点
    */
    private Date timePoint;

    /**
    * 
    */
    private String dataKey;

    /**
    * 单值
    */
    private String monValue;

    /**
    * 标注los(废弃数据)
    */
    private String mark;

    /**
    * 创建时间
    */
    private Date gmtCreate;

    /**
    * 更新时间
    */
    private Date gmtModified;
}