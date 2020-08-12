package com.github.redission.entity;

import lombok.Data;

@Data
public class CreditRiskProfile {

  // XOrdersAttrs.identifier
  private Long id;

  // XOrdersAttrs.accountTenure
  private Long accountTenure;

  // XOrdersAttrs.creditClass
  private String creditClass;

  // XOrdersAttrs.behaviorScore
  private Long behaviorScore;

  // XOrdersAttrs.decisionCriteria
  // to be made an enum[After discussion.]
  private String decisionCriteria;

  // XOrdersAttrs.appRefNum
  private String appRefNum;
}
