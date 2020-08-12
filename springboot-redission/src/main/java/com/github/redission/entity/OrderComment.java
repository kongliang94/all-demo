package com.github.redission.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class OrderComment {

  // ORCOMMENT.LASTUPDATE
  private Date date;

  // ORCOMMENT.COMMENTS
  private String notes;

  // ORCOMMENT.SERVICEREP_ID
  private String user;

}
