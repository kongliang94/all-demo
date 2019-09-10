package com.superstation.entity.dto;

import lombok.Data;

/**
 * @description: 空气查询参数
 * @author: KL
 * @create: 2019-08-03
 */
@Data
public class AirSearchVo {
    private String startDate;
    private String endDate;
    /**
     * 两个监测因子编号
     */
    private String detectionItemCode1;
    private String detectionItemCode2;
    /**
     * 总共9个图表
     */
    private Integer type;
}
