package com.github.springbootshirodemo.controller;

import com.github.springbootshirodemo.common.BaseController;
import com.github.springbootshirodemo.common.Constant;
import com.github.springbootshirodemo.common.model.ResultModel;
import com.github.springbootshirodemo.common.util.JedisUtil;
import com.github.springbootshirodemo.common.util.JwtUtil;
import com.github.springbootshirodemo.common.util.ResultUtils;
import com.github.springbootshirodemo.exception.CustomException;
import com.github.springbootshirodemo.exception.CustomUnauthorizedException;
import com.github.springbootshirodemo.model.LoginUserDto;
import com.github.springbootshirodemo.model.entity.User;
import com.github.springbootshirodemo.service.IUserService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.util.*;

/**
 * @author MrBird
 */
@Validated
@RestController
public class LoginController extends BaseController {

    @Value("${encryption.accessTokenExpireTime}")
    private String accessTokenExpireTime;

    @Autowired
    private IUserService userService;

    @PostMapping("login")
    public ResultModel login(@RequestBody LoginUserDto loginUserDto, HttpServletResponse httpServletResponse) throws CustomException {

        // 密码进行AES解密
        //String key = AesCipherUtil.deCrypto(loginUserDto.getPassword());
        String key=loginUserDto.getUsername() + loginUserDto.getPassword();
        // 因为密码加密是以帐号+密码的形式进行加密的，所以解密后的对比是帐号+密码
        if (key.equals(loginUserDto.getUsername() + loginUserDto.getPassword())) {
            // 清除可能存在的Shiro权限信息缓存
            if (JedisUtil.exists(Constant.PREFIX_SHIRO_CACHE + loginUserDto.getUsername())) {
                JedisUtil.delKey(Constant.PREFIX_SHIRO_CACHE + loginUserDto.getUsername());
            }
            // 设置RefreshToken，时间戳为当前时间戳，直接设置即可(不用先删后设，会覆盖已有的RefreshToken)
            String currentTimeMillis = String.valueOf(System.currentTimeMillis());
            JedisUtil.setObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + loginUserDto.getUsername(), currentTimeMillis, Integer.parseInt(accessTokenExpireTime));
            // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
            String token = JwtUtil.sign(loginUserDto.getUsername(), currentTimeMillis);
            httpServletResponse.setHeader("Authorization", token);
            httpServletResponse.setHeader("Access-Control-Expose-Headers", "Authorization");
            return ResultUtils.success(HttpStatus.OK.value(), "登录成功(Login Success.)", null);
        } else {
            throw new CustomUnauthorizedException("帐号或密码错误(Account or Password Error.)");
        }
    }

    @PostMapping("regist")
    public ResultModel regist(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password) throws CustomException {
        User user = userService.findByName(username);
        if (user != null) {
            throw new CustomException("该用户名已存在");
        }
        this.userService.regist(username, password);
        return ResultUtils.success();
    }

    @GetMapping("index/{username}")
    public ResultModel index(@NotBlank(message = "{required}") @PathVariable String username) {
        // 更新登录时间
        this.userService.updateLoginTime(username);
        Map<String, Object> data = new HashMap<>();


        return ResultUtils.success(data);
    }


    @RequiresAuthentication
    @GetMapping("/test")
    public ResultModel indexTest() {


        return ResultUtils.success("kk");
    }

    /**
     * 获取在线用户(查询Redis中的RefreshToken)
     * @param
     * @return com.wang.model.common.ResponseBean
     * @author dolyw.com
     * @date 2018/9/6 9:58
     */
    @GetMapping("/online")
    @RequiresPermissions(logical = Logical.AND, value = {"user:view"})
    public ResultModel online() {
        List<Object> userDtos = new ArrayList<Object>();
        // 查询所有Redis键
        Set<String> keys = JedisUtil.keysS(Constant.PREFIX_SHIRO_REFRESH_TOKEN + "*");
        for (String key : keys) {
            if (JedisUtil.exists(key)) {
                // 根据:分割key，获取最后一个字符(帐号)
                String[] strArray = key.split(":");


                User userDto = userService.findByName(strArray[strArray.length - 1]);
                // 设置登录时间
                this.userService.updateLoginTime(strArray[strArray.length - 1]);
                userDtos.add(userDto);
            }
        }
        if (userDtos == null || userDtos.size() < 0) {
            throw new CustomException("查询失败(Query Failure)");
        }
        return ResultUtils.success(HttpStatus.OK.value(), "查询成功(Query was successful)", userDtos);
    }

}
