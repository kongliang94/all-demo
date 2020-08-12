package com.github.redission.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Packages {

  // XPackages.PACKAGES_ID
  private Long packageId;

  private boolean gsm;

  // XPackages.PACKAGETYPE
  private String pkgType;

  // XPackages.FIELD6
  private String subPkgType;

  // XPackages.QUANTITY
  private Long packageQty;

  private Long loanId;

  private Long msisdn;

  private String title;

  private PackagePricing pricing;

  private boolean isSimInHand;

  // XPackages.LASTCREATE
  private String lastCreate;

  // XPackages.LASTUPDATE
  private String lastUpdate;

  // XPackages.DESCRIPTION
  private String description;

  // XPackages.CARTLABEL1
  private String cartLabel1;

  // XPackages.CARTLABEL2
  private String cartLabel2;

  // XPackages.CARTLABEL3
  private String cartLabel3;

  // XLineDepositInfo.DEPOCLASS
  private String lineDepositClass;

  // XLineDepositInfo.QUANTITY
  private Long lineDepositQuantity;

  private String poolingRatePlanType;

  // XPackages.FIELD5
  private String sapNumber;

  private Long contractTerm;

  private String planType;

  // XOrdersAttrs.LINELIMITCROSSED
  private boolean lineLimitCrossed;

  private UCCAdminInfo uccAdminInfo;

  private List<TrackingNumberItem> trackingNumberItem = new ArrayList<>();

  private PackageAttribute attributes;

  private ChangeMobileNumber changeMobileNumber;

  private List<OrderItem> items = new ArrayList<>();
}
