package com.github.springbootshirodemo.model;

import lombok.Data;

@Data
public class LoginUserDto {

    private String username;

    /**
     * 密码
     */
    private String password;

    private String verifyCode;

    private boolean rememberMe;
}
