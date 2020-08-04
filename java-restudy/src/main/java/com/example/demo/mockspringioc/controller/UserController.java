package com.example.demo.mockspringioc.controller;

import com.example.demo.mockspringioc.AutoWired;
import com.example.demo.mockspringioc.service.UserService;

public class UserController {

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @AutoWired
    private UserService userService;
}
