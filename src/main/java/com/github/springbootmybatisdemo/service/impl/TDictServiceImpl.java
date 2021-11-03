package com.github.springbootmybatisdemo.service.impl;

import com.github.springbootmybatisdemo.model.TDict;
import com.github.springbootmybatisdemo.dao.TDictMapper;
import com.github.springbootmybatisdemo.service.TDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-05-15
 */
@Service
public class TDictServiceImpl extends ServiceImpl<TDictMapper, TDict> implements TDictService {

}
