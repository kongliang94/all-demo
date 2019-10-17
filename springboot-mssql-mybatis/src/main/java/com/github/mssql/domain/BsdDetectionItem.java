package com.github.mssql.domain;

import lombok.Data;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/7/27 14:09
 * @Created by windows
 */
@Data
public class BsdDetectionItem {
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