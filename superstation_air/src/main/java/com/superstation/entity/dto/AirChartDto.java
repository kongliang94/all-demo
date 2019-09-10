package com.superstation.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @description: 1
 * @author: KL
 * @create: 2019-08-03
 */
@Data
public class AirChartDto {
    private Date timePoint;
    private String monValue1="0";
    private String monValue2="0";
}
