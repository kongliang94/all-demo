package com.github.springbootshirodemo.common.util;

import com.github.springbootshirodemo.common.Constant;
import com.github.springbootshirodemo.exception.CustomException;
import com.github.springbootshirodemo.mapper.UserMapper;
import com.github.springbootshirodemo.model.UserDto;
import com.github.springbootshirodemo.model.entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 获取当前登录用户工具类
 *
 * @author wliduo[i@dolyw.com]
 * @date 2019/3/15 11:45
 */
@Component
public class UserUtil {

    private final UserMapper userMapper;

    public UserUtil(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 获取当前登录用户
     *
     * @param
     * @return com.wang.model.UserDto
     * @author wliduo[i@dolyw.com]
     * @date 2019/3/15 11:48
     */
    public UserDto getUser() {
        String token = SecurityUtils.getSubject().getPrincipal().toString();
        // 解密获得Account
        String account = JwtUtil.getClaim(token, Constant.ACCOUNT);

        UserDto userDto=new UserDto();
        User user = userMapper.findByName(account);
        // 用户是否存在
        if (user == null) {
            throw new CustomException("该帐号不存在(The account does not exist.)");
        }
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }

    /**
     * 获取当前登录用户Id
     *
     * @param
     * @return com.wang.model.UserDto
     * @author wliduo[i@dolyw.com]
     * @date 2019/3/15 11:48
     */
    public Long getUserId() {
        return getUser().getId();
    }

    /**
     * 获取当前登录用户Token
     *
     * @param
     * @return com.wang.model.UserDto
     * @author wliduo[i@dolyw.com]
     * @date 2019/3/15 11:48
     */
    public String getToken() {
        return SecurityUtils.getSubject().getPrincipal().toString();
    }

    /**
     * 获取当前登录用户Account
     *
     * @param
     * @return com.wang.model.UserDto
     * @author wliduo[i@dolyw.com]
     * @date 2019/3/15 11:48
     */
    public String getAccount() {
        String token = SecurityUtils.getSubject().getPrincipal().toString();
        // 解密获得Account
        return JwtUtil.getClaim(token, Constant.ACCOUNT);
    }
}
