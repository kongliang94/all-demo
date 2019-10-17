package com.github.mssql.domain;

import lombok.Data;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/7/21 17:08
 * @Created by windows
 */
@Data
public class SysUser {
    private String userid;

    private String username;

    private String usercode;

    private String loginid;

    private String password;

    private String departmentid;

    private String status;

    private Integer rank;
}