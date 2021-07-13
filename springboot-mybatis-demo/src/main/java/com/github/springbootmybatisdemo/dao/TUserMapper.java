package com.github.springbootmybatisdemo.dao;

import com.github.springbootmybatisdemo.model.TUser;
import com.github.springbootmybatisdemo.model.vo.UserReqVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-05-15
 */
@Mapper
public interface TUserMapper{

    List<TUser> selectByCondition(UserReqVO userReqVO);
}
