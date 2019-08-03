package com.superstation.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @description: 仪器监控
 * @author: KL
 * @create: 2019-07-31
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Moniter5m20191001B {
    private Date timePoint;

    private String brand;

    private String series;

    private String statusName;

    private String detectionCode;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String stationCode;

    private String statusValue;

    private String mark;

    private String unit;
}
