package com.github.redission.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderAttribute {

  private BANInfoDetails banInfo;

  // XOrdersAttrs.SIM_ON_HAND_SOFT_GOOD_ORDER
  private boolean sIMOnHandSoftGood;

  // XOrdersAttrs.isSIHEnabedPartner
  private boolean sIHEnabledPartner;

  // XOrdersAttrs.isTMOOnePlan
  private boolean tMOOnePlan;

  // XOrdersAttrs.AresDiscountAllowed
  private boolean aresDiscountAllowed;

  // XOrdersAttrs.LINE_QUANTITY_MISMATCH
  private boolean lineQuantityMismatch;

  // XOrdersAttrs.DEPOCLASS
  private String depoClass;

  // XOrdersAttrs.EC_LIMIT_ZERO
  private boolean ecLimitZero;

  // XOrdersAttrs.isReturnReorder
  private boolean returnOrder;

  // XOrdersAttrs.RETURN_CODE
  // To be made an Enum[Discussion.]
  private String returnCode;

  // XOrdersAttrs.isPartialReturn
  private boolean partialReturn;

  // XOrdersAttrs.SSP_USER_ID
  private Long userId;

  private EIPDetails eip;

  // XOrdersAttrs.LastMonthEIPPaymentAmount
  private Double lastMonthEIPPaymentAmount;

  // XOrdersAttrs.HISTORIC_DATE
  private Timestamp eipHistoricDate;

  // XOrdersAttrs.
  private boolean priceOverride;

  // XOrdersAttrs.PartnerHandshakeSuccess
  private boolean partnerHandshakeSuccess;

  // XOrdersAttrs.FULL_ACTIVATION
  private boolean fullActivation;

  // XOrdersAttrs.inventoryStatus
  // To be made an Enum[Discussion.]
  private String inventoryStatus;

  // XOrdersAttrs.ALT_ACTIVATION_NAME
  private String alternateActivationName;

  // XOrdersAttrs.ALT_ACTIVATION_MAIL_ID
  private String alternateActivationEmailId;

  // XOrdersAttrs.isfullAuthSuccess
  private boolean paymentFullAuthSucess;

  // XOrdersAttrs.fullAuthPayTypeCode
  private String fullAuthPayTypeCode;

  // XOrdersAttrs.taxAreaIdForShipTo_shpCharge
  private Long taxAreaIdForShipTo;

  // XOrdersAttrs.CANCELLED_BY
  private String cancelledBy;

  // XOrdersAttrs.waiveShipping
  private boolean waiveShipping;

  // XOrdersAttrs.isCartValid
  private boolean cartValid;

  // XOrdersAttrs.SIM_ACTIVATION
  private boolean simActivationSuccess;

  // XOrdersAttrs.SUBMITTED_EASY_ORDER
  private boolean easyOrderSubmitted;

  // XOrdersAttrs.isBulkSIHOrder
  private boolean bulkSIHOrder;

  // XOrdersAttrs.isPortIn
  private boolean portIn;

  // XOrdersAttrs.VALIDATE_DEALER_CODE
  private boolean dealerCodeFromSFDC;

  // XOrdersAttrs.hasGetCartExecuted
  private boolean getCartExceuted;

  // XOrdersAttrs.isVenicomOrder
  private boolean venicomOrder;

  // XOrdersAttrs.isVirtualOnlyOrder
  private boolean virtualOnlyOrder;

  // XOrdersAttrs.IL_PAY_DISABLED
  private boolean iLPayDisabled;

  // XOrdersAttrs.ERRORED_OUT
  private boolean erorred;

  // XOrdersAttrs.isRoambeeOrder
  private boolean roambeeOrder;

  // XOrdersAttrs.isPreAuthSuccess
  private boolean preAuthSuccess;

  // XOrdersAttrs.CONFIRMATION_EMAIL
  private String orderConfirmationEmailId;

  // XOrdersAttrs.IS_CC_PMT_USED
  private boolean creditCardPaymentMethod;

  // XOrdersAttrs.ESP_ORDER_ID
  private String espOrderId;

  // XOrdersAttrs.orderCancelReason
  // Can be an Enum[Discussion.]
  private String orderCancelReason;

  // XOrdersAttrs.mrcBillingSameAsContact
  private boolean mrcBillingSameAsContact;

  // XOrdersAttrs.PPUSameAsShipping
  private boolean pPUSameAsShipping;

  // XOrdersAttrs.BillingSameAsContact
  private boolean billingSameAsContact;

  // XOrdersAttrs._ORDER_ACTIVATION_MAIL_SENT
  private boolean orderActivationEmailSent;

  // XOrdersAttrs.isPreAuth
  private boolean preAuth;

  // XOrdersAttrs.SAMSON_ORDER_ID
  private Long[] samsonOrderId;

  // XOrdersAttrs.isSubsidyRP
  private boolean subsidyRP;

  // XOrdersAttrs.signUpEasyPay
  private boolean signUpForEasyPay;

  // XOrdersAttrs.BUSINESS_NAME
  private String businessName;

  // XOrdersAttrs.languagePreference
  private String languagePreference;

  // XOrdersAttrs.depId
  private String appleDepId;

  // XOrdersAttrs.MANUAL_ACTIVATION
  private boolean manualActivation;

  // XOrdersAttrs.WIP_CUST_ID
  private String wipCustomerId;

  // XOrdersAttrs.isCheckoutCompleted
  private boolean checkoutCompleted;

  private boolean uCCSeatSyncSubmitFailed;
}
