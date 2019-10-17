package com.superstation.entity;

import java.util.Date;
import lombok.Data;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/7/31 13:39
 * @Created by windows
 */
@Data
public class Air1m20191001B {
    /**
    * 
    */
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