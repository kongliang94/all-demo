package com.github.mssql.mapper;

import com.github.mssql.domain.SysUser;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/7/21 17:08
 * @Created by windows
 */
public interface SysUserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}