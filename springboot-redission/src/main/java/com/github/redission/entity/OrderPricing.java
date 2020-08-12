package com.github.redission.entity;

import lombok.Data;

@Data
public class OrderPricing {

  // Order.TOTALPRODUCT
  private Double totalProduct;

  // Order.TOTALTAX
  private Double totalTax;

  // Order.TOTALSHIPPING
  private Double totalShipping;

  // Order.TOTALTAXSHIPPING
  private Double totalTaxShipping;

  // Order.TOTALADJUSTMENT
  private Double totalAdjustment;

  // XOrders.TOTALFEE
  private Double totalFee;

  // XOrders.TOTALAMOUNT_TOCHARGE
  private Double totalAmountToCharge;

  // XOrders.TOTALDEPOSITAMOUNT
  private Double totalDepositAmount;

  private Double downpayment;

  private Double lastMonthEIPPaymentAmount;

  // XOrdersAttrs.MIN_FIRST_INSTALLMENT
  private Double minimumFirstInstallment;

  // XOrdersAttrs.MonthlyInstallmentUpdated
  private Double monthlyInstallmentAmount;

  // XOrdersAttrs.AT_ORD_ATTR_TOTAMNT_FINANCED
  private Double totalAmountFinanced;

  // XOrdersAttrs.AT_ORD_ATTR_REM_BALANCE
  private Double totalRemainingBalance;

  private Double totalFinancedAmount;

}
