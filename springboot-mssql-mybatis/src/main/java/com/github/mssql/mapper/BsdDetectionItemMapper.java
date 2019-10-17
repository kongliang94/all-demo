package com.github.mssql.mapper;

import com.github.mssql.domain.BsdDetectionItem;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/7/27 14:09
 * @Created by windows
 */
public interface BsdDetectionItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(BsdDetectionItem record);

    int insertSelective(BsdDetectionItem record);

    BsdDetectionItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BsdDetectionItem record);

    int updateByPrimaryKey(BsdDetectionItem record);
}