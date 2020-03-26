package com.github.springbootshirodemo.controller;

import com.github.springbootshirodemo.common.model.ResultModel;
import com.github.springbootshirodemo.common.util.ResultUtils;
import com.github.springbootshirodemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private IUserService userService;

    @GetMapping("/api/users")
    public ResultModel getAllUser(){
        return ResultUtils.success(userService.list()) ;
    }
}
