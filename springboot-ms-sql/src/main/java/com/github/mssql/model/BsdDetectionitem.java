package com.github.mssql.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/7/27 14:09
 * @Created by windows
 */
@Data
@Entity
@Table(name = "BSD_Detectionitem")
public class BsdDetectionitem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    private String parentid;

    private String alias;

    private String displayname;

    private String typeid;

    private String unitid;

    private Integer rank;

    private Boolean enabled;

    private String detectionitemcode;

    private String availableunitids;

    private Integer relativemolecularmass;

    private String instrumenttypeid;

    private String displayunitid;

    private String usename;

    private Integer decimal;

    private String datakeyunitid;

    private String datakeydisplayunitid;
}