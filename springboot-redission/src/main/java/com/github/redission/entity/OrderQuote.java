package com.github.redission.entity;

import lombok.Data;

@Data
public class OrderQuote {

  // XOrdersAttrs.quoteNumber
  private String quoteNumber;

  private Long masterOrderId;

  // XOrdersAttrs.quoteAutoPayEnroll
  private boolean quoteAutoPayEnroll;

  // XOrdersAttrs.salesRepEmail
  private String salesRepEmail;

  // XOrdersAttrs.salesRepName
  private String salesRepName;

  // XOrdersAttrs.opportunityID
  private String opportunityId;

  // XOrdersAttrs.AccountName
  private String businessAccountName;

  // XOrdersAttrs.customerPhone
  private String customerPhone;

  // XOrdersAttrs.customerName
  private String customerName;

  // XOrdersAttrs.isCC
  private boolean dueNowPayMethodCreditCard;

  // XOrdersAttrs.REMINDER_SENT
  private boolean quoteEmailReminderSentToCustomer;

  // XOrdersAttrs.ISCANCREKEY
  private boolean cancelrekeySFDC;

  // XOrdersAttrs.CUST_EMAIL_ID
  private String customerEmailId;

  private boolean easyOrder;

  private boolean sFDCSynced;

}
