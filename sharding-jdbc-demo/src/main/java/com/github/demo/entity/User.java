package com.github.demo.entity;


import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_user")
public class User {
    private Long userId;
    private String username;
    private String ustatus;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus;
    }
}
