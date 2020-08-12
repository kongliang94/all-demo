package com.github.redission.entity;

import lombok.Data;

import java.sql.Clob;
import java.sql.Timestamp;

@Data
public class PortIn {

  // XBCNUMPORTIN.CHNGREQ_ID
  private Long changeRequestId;

  // XBCNUMPORTIN.ACCT_NUM
  private Long accountNumber;

  // XBCNUMPORTIN.ACCT_PASSWD
  private String accountPassword;

  // XBCNUMPORTIN.
  private String businessName;

  // XBCNUMPORTIN.REQ_DATE_CHG
  private Timestamp changeDate;

  // XBCNUMPORTIN.CITY
  private String city;

  // XBCNUMPORTIN.PORTIN_MOB_NUM
  private Clob contactNumber;

  // XBCNUMPORTIN.PREV_PORTIN_CARRIER
  private String currentCarrier;

  // XBCNUMPORTIN.EXIST_MOB_NUM
  private String currentMsisdn;

  // XBCNUMPORTIN.
  private String emailAddress;

  // XBCNUMPORTIN.FIRST_NAME
  private String firstName;

  // XBCNUMPORTIN.LAST_NAME
  private String lastName;

  // XBCNUMPORTIN.PREV_CARRIER
  private String previousCarrier;

  // XBCNUMPORTIN.
  private Long quantity;

  // XBCNUMPORTIN.SSN
  private String ssn;

  // XBCNUMPORTIN.ST_ADDR_1
  private String stAddress1;

  // XBCNUMPORTIN.ST_ADDR_2
  private String stAddress2;

  // XBCNUMPORTIN.STATE
  private String stateCode;

  // XBCNUMPORTIN.TAXID
  private String taxId;

  // XBCNUMPORTIN.ZIPCODE
  private String zipCode;

  // XBCNUMPORTIN.
  private String portInClass;
}
