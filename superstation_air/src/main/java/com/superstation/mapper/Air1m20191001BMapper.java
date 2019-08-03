package com.superstation.mapper;

import com.superstation.entity.Air1m20191001B;
import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/7/31 14:56
 * @Created by windows
 */
@Mapper
public interface Air1m20191001BMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Air1m20191001B record);

    int insertSelective(Air1m20191001B record);

    Optional<Air1m20191001B> selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Air1m20191001B record);

    int updateByPrimaryKey(Air1m20191001B record);

    List<Air1m20191001B> selectByRange(@Param("detectionItemCode") String detectionItemCode,@Param("start")String start, @Param("end")String end);

}