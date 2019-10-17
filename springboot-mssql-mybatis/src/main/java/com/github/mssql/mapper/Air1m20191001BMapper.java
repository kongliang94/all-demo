package com.github.mssql.mapper;

import com.superstation.entity.Air1m20191001B;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/7/31 13:39
 * @Created by windows
 */
public interface Air1m20191001BMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Air1m20191001B record);

    int insertSelective(Air1m20191001B record);

    Air1m20191001B selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Air1m20191001B record);

    int updateByPrimaryKey(Air1m20191001B record);
}