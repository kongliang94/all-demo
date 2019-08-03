package com.superstation.entity.dto;

import lombok.Data;

import java.util.Date;

/**
 * @description: 一氧化碳
 * @author: KL
 * @create: 2019-07-31
 */
@Data
public class CO {

    private Date timePoint;

    /**
     * 单值
     */
    private String monValue;
}
