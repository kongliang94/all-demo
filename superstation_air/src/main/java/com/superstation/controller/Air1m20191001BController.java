package com.superstation.controller;

import com.superstation.entity.Air1m20191001B;
import com.superstation.exception.ResourceNotFoundException;
import com.superstation.mapper.Air1m20191001BMapper;
import com.superstation.util.LocalDateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @description: 空气
 * @author: KL
 * @create: 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class Air1m20191001BController {

    final Air1m20191001BMapper air1m20191001BMapper;

    public Air1m20191001BController(Air1m20191001BMapper air1m20191001BMapper) {
        this.air1m20191001BMapper = air1m20191001BMapper;
    }

    @GetMapping("/air1m20191001B/{detectionItemCode}/all")
    public ResponseEntity getAllByRange(@PathVariable String detectionItemCode){
        LocalDateTime endDate=LocalDateTime.now();
        LocalDateTime startDate=endDate.minusDays(1);

        log.info("start={},end={}",startDate,endDate);
        List<Air1m20191001B> air1m20191001BS=air1m20191001BMapper.selectByRange(detectionItemCode,
                LocalDateTimeUtils.formatTime(startDate,"yyyy-MM-dd HH:mm:ss"),
                LocalDateTimeUtils.formatTime(endDate,"yyyy-MM-dd HH:mm:ss"));
       /* List<Air1m20191001B> air1m20191001BList=air1m20191001BS
                .parallelStream()
                .filter(air1m20191001B -> StringUtils.isEmpty(air1m20191001B.getMark())).collect(Collectors.toList());*/
        return ResponseEntity.ok(air1m20191001BS);
    }

    @GetMapping("/air1m20191001B/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        return ResponseEntity.ok(air1m20191001BMapper.selectByPrimaryKey(id)
                .orElseThrow(()->new ResourceNotFoundException("无资源")));
    }
}
