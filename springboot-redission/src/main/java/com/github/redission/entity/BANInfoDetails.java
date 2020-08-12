package com.github.redission.entity;

import lombok.Data;

@Data
public class BANInfoDetails {

  // XOrdersAttrs.BAN_GSM_QUANTITY
  private Long banGSMQuantity;

  // XOrdersAttrs.BAN_GSMCount
  private Integer banGSMCount;

  // XOrdersAttrs.hasGSMLines
  private boolean banHasGSMLines;

  // XOrdersAttrs.hasGSMInCart
  private boolean gSMInCart;

  // XOrdersAttrs.IS_BAN_GSM_INDV
  private boolean banGSMIndividual;

  // XOrdersAttrs.IS_BAN_GSM_POOL
  private boolean banGSMPooling;

  // XOrdersAttrs.BAN_MBB_QUANTITY
  // Need to evaluate
  private Long banMBBQuantity;

  // XOrdersAttrs.hasMBBInCart
  private boolean mBBInCart;

  // XOrdersAttrs.ppMaxLines
  private Long poolingPlanMaxLines;

  // XOrdersAttrs.ppMinLines
  private Long poolingPlanMinLines;

  // XOrdersAttrs.ppLineCount
  private Long poolingPlanLineCount;

  // XOrdersAttrs.poolingRPInRequest
  private String poolingRatePlanInRequest;

  // XOrdersAttrs.banCorpNode
  private Long banCorpNode;

  // XOrdersAttrs.banReasonCode
  // to be made an Enum[Discussion.]
  private String banReasonCode;

  // XOrdersAttrs.isBANEnrolledForAutoPay
  private boolean banEnrolledForAutoPay;

  // XOrdersAttrs.BANAutoIneligibilityReason
  private String banAutoPayIneligibilityReason;

  // XOrdersAttrs.IS_AUTOPAY
  private boolean autopay;

  // XOrdersAttrs.autoPayEnroll
  private boolean autoPayEnroll;

  // XOrdersAttrs.BANAutoPayServiceFailure
  private String banAutoPayServiceFailure;

  // XOrdersAttrs.ACCOUNT_STATUS
  // To be made an Enum[Discussion.]
  private String accountStatus;

  // XOrdersAttrs.ACCOUNT_SUB_TYPE
  // To be made an Enum[Discussion.]
  private String accountSubType;

  // XOrdersAttrs.ACCOUNT_TYPE
  // To be made an Enum[Discussion.]
  private String accountType;

  // XOrdersAttrs.banStatus
  // To be made an Enum[Discussion.]
  private String banStatus;

  // XOrdersAttrs.BAN_TAX_INDICATOR
  // Can be an Enum[Discussion.]
  private String banTaxIndicator;
}
