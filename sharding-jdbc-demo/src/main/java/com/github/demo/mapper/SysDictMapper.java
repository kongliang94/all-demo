package com.github.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.demo.entity.SysDict;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysDictMapper extends BaseMapper<SysDict> {
}