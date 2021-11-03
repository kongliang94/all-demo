package com.github.springbootmybatisdemo.service.impl;

import com.github.springbootmybatisdemo.model.TUser;
import com.github.springbootmybatisdemo.dao.TUserMapper;
import com.github.springbootmybatisdemo.service.TUserService;
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
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
