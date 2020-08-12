package com.github.redission.entity;

import lombok.Data;

@Data
public class DatabaseSequence {

  // @Id
  private String id;

  private Long sequence;
}
