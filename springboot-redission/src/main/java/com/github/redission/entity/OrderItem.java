package com.github.redission.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderItem {

  // OrderItems.ORDERITEMS_ID
  private Long id;

  // OrderItems.CATENTRY_ID
  private Long catentryId;

  // OrderItems.PARTNUM
  // XOrderItemAttrs.PartNumber
  private String partNumber;

  // OrderItems.PRICE
  private Double offerPrice;

  // OrderItems.LASTCREATE
  private Timestamp lastCreate;

  // OrderItems.LASTUPDATE
  private Timestamp lastUpdate;

  // OrderItems.LASTALLOCUPDATE
  private Timestamp lastAllocUpdate;

  // OrderItems.TOTALPRODUCT
  private Double totalProduct;

  // OrderItems.QUANTITY
  private Long quantity;

  // OrderItems.TAXAMOUNT
  private Double taxAmount;

  // OrderItems.TOTALADJUSTMENT
  private Double totalAdjustment;

  // OrderItems.SHIPTAXAMOUNT
  private Double shipTaxAmount;

  // OrderItems.SHIPCHARGE
  private Double shipCharge;

  // OrderItems.BASEPRICE
  // XOrderItemAttrs.salePrice
  private Double basePrice;

  // OrderItems.REQUESTEDSHIPDATE
  private Timestamp requestedShipDate;

  // XOrderItems.RECURRING
  private boolean recurring;

  // XOrderItems.AMOUNT_TOCHARGE
  private Double amountToCharge;

  // XOrderItems.FIELD2
  private Long numberOfInstallment;

  // XOrderItems.FIELD3
  private Double downpayment;

  // XOrderItems.FIELD4
  private Double monthlyInstallment;

  // XOrderItems.FIELD5
  // XOrderItemAttrs.list_price
  private Double listPrice;

  // XOrderItems.FIELD6
  private Double eipSalePrice;

  // not-found
  private String itemType;
  // not-found
  private Long productId;
  // not-found
  private String title;
  // not-found
  private String isTrial;

  // XOrderItems.FIELD7
  private Double downpaymentDiscount;

  private Timestamp timeReleased;

  private Timestamp timeShipped;

  private List<InventoryDateRange> inventoryDateRange = new ArrayList<>();

  // XOrderItemAttrs.RULE_ID
  private Long ruleId;

  // XOrderItemAttrs.PLAN_ID
  private Long planId;

  // XOrderItemAttrs.shippedQuantity
  private Long shippedQuantity;

  // XOrderItemAttrs.MonthlyInstallmentUpdated
  private Double monthlyInstallmentAmount;

  // XOrderItemAttrs.PLAN_CREATIONDATE
  private Timestamp planCreationDate;

  // XOrderItemAttrs.PAYMENT_DUEDATE
  private Timestamp paymentDueDate;

  // XOrderItemAttrs.DISCOUNT_PERCENTAGE
  private Double discountPercentage;

  // XOrderItemAttrs.LastMonthPaymentDueDate
  private Timestamp lastMonthPaymentDueDate;

  // XOrderItemAttrs.ORD_ATTR_TOTAMNT_FINANCED
  private Double totalAmountFinanced;

  // XOrderItemAttrs.isRemoved
  private boolean removed;

  // XOrderItemAttrs.priceOverride
  private boolean priceOverride;

}
