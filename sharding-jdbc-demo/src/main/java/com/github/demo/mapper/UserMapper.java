package com.github.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
