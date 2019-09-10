package com.github.mssql.model;


import javax.persistence.*;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/7/21 17:08
 * @Created by windows
 */
@Entity
@Table(name = "SYS_User")
public class SysUser {
    private String userid;

    private String username;

    private String usercode;

    private String loginid;

    private String password;

    private String departmentid;

    private String status;

    private Integer rank;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}