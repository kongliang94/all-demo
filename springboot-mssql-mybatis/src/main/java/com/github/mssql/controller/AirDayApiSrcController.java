package com.github.mssql.controller;

import com.github.mssql.domain.AirDayApiSrc;
import com.github.mssql.mapper.AirDayApiSrcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: Air
 * @author: KL
 * @create: 2019-07-19
 */
@RestController
public class AirDayApiSrcController {

    @Autowired
    private AirDayApiSrcMapper airDayApiSrcMapper;

    @GetMapping("/airDayApiSrc")
    public List<AirDayApiSrc> getAllAirDayApiSrc() {
        return airDayApiSrcMapper.findAll();
    }

    @GetMapping("/airDayApiSrc/{id}")
    public AirDayApiSrc getAirDayApiSrc(@PathVariable Integer id) {
        return airDayApiSrcMapper.selectById(id);
    }
}
