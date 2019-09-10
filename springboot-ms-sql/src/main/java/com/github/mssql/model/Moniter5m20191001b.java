package com.github.mssql.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/7/23 23:34
 * @Created by windows
 */
@Data
@Entity
@Table(name = "Moniter_5m_2019_1001b")
public class Moniter5m20191001b {
    private Date timepoint;

    private String brand;

    private String series;

    private String statusname;

    private String pollutantcode;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String stationcode;

    private String value;

    private String mark;

    private String unit;
}