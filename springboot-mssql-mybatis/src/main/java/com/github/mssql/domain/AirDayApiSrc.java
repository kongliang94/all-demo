package com.github.mssql.domain;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/7/19 17:42
 * @Created by windows
 */
@Data
public class AirDayApiSrc {
    private String stationCode;

    private Date date;

    private Integer id;

    private String area;

    private BigDecimal so2;

    private BigDecimal pm10;

    private BigDecimal no2;

    private Integer api;

    private String primaryPollutant;

    private String type;

    private String level;

    private String description;

    private String so2Mark;

    private String no2Mark;

    private String pm10Mark;
}