package com.github.redission.entity;

import lombok.Data;

@Data
public class PackagePricing {

  private String areaDiscountAmount;

  // XPackages.TOTALPRODUCT
  private Double totalProduct;

  // XPackages.TOTALFEE
  private Double totalFee;

  // XPackages.TOTALAMOUNT_TOCHARGE
  private Double totalAmountToCharge;

  // XPackages.DEPOSITAMOUNT
  private Double depositAmount;

  // XLineDepositInfo.DEPOSITAMOUNT
  private Double depositAmountPerLine;

  private Double dueMonthlyAmount;

  private Double monthlyAmount;

  private Double totalAmount;
}
