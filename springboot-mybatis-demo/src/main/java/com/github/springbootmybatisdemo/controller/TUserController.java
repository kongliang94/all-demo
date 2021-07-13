package com.github.springbootmybatisdemo.controller;


import com.github.springbootmybatisdemo.dao.TUserMapper;
import com.github.springbootmybatisdemo.model.TUser;
import com.github.springbootmybatisdemo.model.vo.UserReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-05-15
 */
@RestController
@RequestMapping("/user")
public class TUserController {

    @Autowired
    TUserMapper userMapper;
    @PostMapping("/getAll")
    public List<TUser> getPage(@RequestBody UserReqVO userReqVO){

        return userMapper.selectByCondition(userReqVO);
    }

}

