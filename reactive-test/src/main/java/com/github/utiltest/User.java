package com.github.utiltest;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String userId;
    private String name;
    private Integer age;
    private Date birthday;
    private String email;
}
