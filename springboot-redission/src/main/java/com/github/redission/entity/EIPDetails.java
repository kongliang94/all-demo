package com.github.redission.entity;

import lombok.Data;

@Data
public class EIPDetails {

  // XOrdersAttrs.EIP_DISC_EMAIL
  private String eipDisclosureEmail;

  // XOrdersAttrs.isEIPPlanCancelled
  private boolean eipPlanCancelled;

  // XOrdersAttrs.cancelEIPStatus
  private boolean cancelEIPStatus;

  // XOrdersAttrs.hasEIPPackage
  private boolean hasEIPPackage;

  // XOrdersAttrs.telcomngrSignEIPOrder
  private boolean eIPOrderSignedByTelecomManager;

  // XOrdersAttrs.NOTIFY_ACCEPTANCE
  private boolean eipDocumentAccepted;

  // XOrdersAttrs.financialApproverEmailId
  private String financialApproverEmailId;

  // XOrdersAttrs.financialApproverFirstName
  private String financialApproverFirstName;

  // XOrdersAttrs.financialApproverLastName
  private String financialApproverLastName;

  // XOrdersAttrs.financialApproverSameAsShipping
  private boolean financialApproverSameAsShipping;

  // XOrdersAttrs.financialApproverSameAsContact
  private boolean financialApproverSameAsContact;

  // XOrdersAttrs.counter
  private Integer cancelEIPRetryCount;
}
