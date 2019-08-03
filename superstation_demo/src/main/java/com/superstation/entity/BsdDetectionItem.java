package com.superstation.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/7/27 14:09
 * @Created by windows
 */
@Data
public class BsdDetectionItem {

    private Long id;

    private String name;

    private Long parentId;

    private String alias;

    private String displayName;

    private Long typeId;

    private Long unitId;

    private Integer rank;

    private Boolean enabled;

    private String detectionItemCode;

    private String availableUnitIds;

    private Integer relativeMolecularMass;

    private String instrumentTypeid;

    private String displayunitId;

    private String usename;

    private Integer decimal;

    private String datakeyunitid;

    private String datakeydisplayunitid;
}