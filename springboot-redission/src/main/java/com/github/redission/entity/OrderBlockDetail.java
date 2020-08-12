package com.github.redission.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderBlockDetail {

  // ORDERBLK.ORDERBLK_ID
  // Auto-Generated Id
  private Long orderBlockId;

  // ORDERBLK.BLKCOMMENT
  private String blockComment;

  // ORDERBLK.RESOLVED
  private boolean resolved;

  // ORDERBLK.TIMEBLOCKED
  private Timestamp timeBlocked;

  private BlockReasonEntity blockReason;
}
