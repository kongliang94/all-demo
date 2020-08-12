package com.github.redission.entity;

import lombok.Data;

@Data
public class Address {

  // Address.ADDRESSTYPE
  private String addressType;

  // Address.MEMBER_ID
  private Long memberId;

  // Address.LASTNAME
  private String lastName;

  // Address.ORGUNITNAME
  private String orgUnitName;

  // Address.ORGNAME
  private String orgName;

  // Address.ISPRIMARY
  private Boolean primary;

  // Address.FIRSTNAME
  private String firstName;

  // Address.MIDDLENAME
  private String middleName;

  // Address.PERSONTITLE
  private String personTitle;

  // Address.BUSINESSTITLE
  private String businessTitle;

  // Address.PHONE1
  private String phone1;

  // Address.FAX1
  private String fax1;

  // Address.PHONE2
  private String phone2;

  // Address.FAX2
  private String fax2;

  // Address.ADDRESS1
  private String addressLine1;

  // Address.ADDRESS2
  private String addressLine2;

  // Address.ADDRESS3
  private String addressLine3;

  // Address.CITY
  private String city;

  // Address.STATE
  private String state;

  // Address.COUNTRY
  private String country;

  // Address.ZIPCODE
  private String zipCode;

  // Address.EMAIL1
  private String email1;

  // Address.EMAIL2
  private String email2;

  private String shipToContactName;

  private boolean addressOverride;

}
