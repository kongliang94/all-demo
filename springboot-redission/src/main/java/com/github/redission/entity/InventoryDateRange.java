package com.github.redission.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class InventoryDateRange {

  private Timestamp esdFrom;

  private Timestamp esdTo;

  private Long feedQuantity;
}
