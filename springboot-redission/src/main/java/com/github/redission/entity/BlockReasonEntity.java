package com.github.redission.entity;

import lombok.Data;

@Data
public class BlockReasonEntity {

  // @Id
  private String id;

  // BLKRSNCODE.BLKRSNCODE_ID
  private Long blockReasonCode;

  // BLKRSNCODE.BLOCKREASONTYPE
  private String blockReasonType;

  // BLKRSNCODE.MANUALBLOCK
  private boolean manualBlock;

  // BLKRSNCODE.MARKFORDELETE
  private boolean markForDelete;

  // BLKRSNDESC.DESCRIPTION
  private String blockReasonDescription;
}
