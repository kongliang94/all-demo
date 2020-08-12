package com.github.redission.entity;

import lombok.Data;

@Data
public class PackageAttribute {

  // XPackageAttrs.notes
  private String notes;

  // XPackageAttrs.shippedQty
  private Long shippedQty;

  // XPackageAttrs.status
  // to be made as an enum
  private String status;

  // XPackageAttrs.totalAdditionalLines
  private Long totalAdditionalLines;

  // XPackageAttrs.tracking_number
  private String trackingNumber;

  // XPackageAttrs.additionalLinePrice
  private Double additionaLinePrice;

  // XPackageAttrs.includedLinePrice
  private Double includedLinePrice;

  // XPackageAttrs.DELETEService
  private String deleteService;

  // XPackageAttrs.miLines
  private Long miLines;

  // XPackageAttrs.Validation_Errors
  private String[] validationErrors;

  // XPackageAttrs.activationFee
  private Double activationFee;

  // XPackageAttrs.lineDeposit
  private Double lineDeposit;

  // XPackageAttrs.shippedMsisdn
  private String shippedMsisdn;

  // XPackageAttrs.ADDUCCService
  private String addUCCService;

  // XPackageAttrs.SAP_PROCESSED
  private boolean sapProcessed;

  // XPackageAttrs.CHANGE_IN_AMOUNT
  private boolean changeInAmount;

  // XPackageAttrs.PACKAGE_REFERENCE_ID
  private Long packageReferenceId;

  // XPackageAttrs.miLinePrice
  private Double miLinePrice;

  // XPackageAttrs.SIM_CONT_LENGTH
  private Integer simContLength;

  // XPackageAttrs.includedLines
  private boolean includedLines;

  // XPackageAttrs.totalDueMonthly
  private Double totalDueMonthly;

  // XPackageAttrs.poNumber
  private String poNumber;

  // XPackageAttrs.ADDService
  private String addService;

}
