package com.github.springbootshirodemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.springbootshirodemo.model.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author MrBird
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}
