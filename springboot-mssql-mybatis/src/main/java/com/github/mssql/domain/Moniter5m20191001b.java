package com.github.mssql.domain;

import java.util.Date;
import lombok.Data;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/7/23 23:34
 * @Created by windows
 */
@Data
public class Moniter5m20191001b {
    private Date timepoint;

    private String brand;

    private String series;

    private String statusname;

    private String pollutantcode;

    private Integer id;

    private String stationcode;

    private String value;

    private String mark;

    private String unit;
}