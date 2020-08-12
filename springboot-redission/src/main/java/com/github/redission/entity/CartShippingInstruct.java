package com.github.redission.entity;

import lombok.Data;

@Data
public class CartShippingInstruct {

  private Double shippingCharge;

  // to be made an enum[After discussion.]
  private String shippingChargeType;

  // Need to check.
  private String shippingMode;

  // Need to check.
  private String shippingModeId;

  private String shippingModeDescription;

}
