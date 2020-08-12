package com.github.redission.entity;

import lombok.Data;

@Data
public class OrderHeader {

  // Order.ORGENTITY_ID
  private Long organizationId;

  // XOrders.ORG_NAME
  private String organizationName;

  private String ccId;

  private String dealerEmailId;

  // Order.MEMBER_ID
  // @NotNull
  private Long memberId;

  private String logonId;

  private Long ssn;

  // XOrders.BAN
  private String ban;

  private Long taxId;

  private Long dealerCode;

  // To be an Enum.
  private String applicationType;

  // XOrdersAttrs.BUSINESS_SEGMENT
  // To be made an Enum[Discussion.]
  private String businessSegment;

  // XOrdersAttrs.CORP_NODE
  private String orgCorpNode;

  // XOrdersAttrs.SFDC
  // XOrdersAttrs.SSP_CHANNEL
  // To be made an Enum[Discussion.]
  private String orderChannel;

  private String channelType;

  // XOrdersAttrs.sscFlow
  private boolean sscFlow;

  // XOrdersAttrs.IS_SSP_ORDER
  private boolean sSPOrder;

  // XOrdersAttrs.clientId
  // Can be an Enum[Discussion]
  private String clientID;

}
