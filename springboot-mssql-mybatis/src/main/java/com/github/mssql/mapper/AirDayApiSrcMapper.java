package com.github.mssql.mapper;

import com.github.mssql.domain.AirDayApiSrc;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/7/19 17:42
 * @Created by windows
 */
@Mapper
public interface AirDayApiSrcMapper {
    int deleteByPrimaryKey(@Param("stationCode") String stationCode, @Param("date") Date date);

    int insert(AirDayApiSrc record);

    int insertSelective(AirDayApiSrc record);

    AirDayApiSrc selectById(@Param("id")Integer id);

    AirDayApiSrc selectByPrimaryKey(@Param("stationCode") String stationCode, @Param("date") Date date);

    int updateByPrimaryKeySelective(AirDayApiSrc record);

    int updateByPrimaryKey(AirDayApiSrc record);

    List<AirDayApiSrc> findAll();

}