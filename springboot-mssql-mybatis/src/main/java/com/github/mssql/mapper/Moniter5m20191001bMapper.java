package com.github.mssql.mapper;

import com.github.mssql.domain.Moniter5m20191001b;
import java.util.Date;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/7/23 23:34
 * @Created by windows
 */
public interface Moniter5m20191001bMapper {
    int deleteByPrimaryKey(@Param("timepoint") Date timepoint, @Param("brand") String brand, @Param("series") String series, @Param("statusname") String statusname, @Param("pollutantcode") String pollutantcode);

    int insert(Moniter5m20191001b record);

    int insertSelective(Moniter5m20191001b record);

    Moniter5m20191001b selectByPrimaryKey(@Param("timepoint") Date timepoint, @Param("brand") String brand, @Param("series") String series, @Param("statusname") String statusname, @Param("pollutantcode") String pollutantcode);

    int updateByPrimaryKeySelective(Moniter5m20191001b record);

    int updateByPrimaryKey(Moniter5m20191001b record);
}