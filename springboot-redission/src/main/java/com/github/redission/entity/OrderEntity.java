package com.github.redission.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderEntity {

  // @Id
  private Long orderId;

  private OrderHeader header;

  // Order.STATUS
  private String orderStatus;

  // Order.BLOCKED
  private boolean blocked;

  // Order.LOCKED
  private boolean orderLocked;

  private OrderPricing pricing;

  private OrderAudit audit;

  // Order.DESCRIPTION
  private String description;

  private String orderType;

  // Order.COMMENTS
  private String comments;

  // XOrders.SHIPASCOMPLETE
  // Order.SHIPASCOMPLETE
  // Need to evaluate
  private boolean shipAsComplete;

  // XOrders.NOTIFICATION_RECIPIENTS
  private String notificationRecipients;

  // XOrders.FIELD3
  private boolean orderNotifiedToOSR;

  // Need to evaluate
  private Timestamp processedTime;

  // XOrders.ESDFROM
  private Timestamp esdFrom;

  // XOrders.ESDTO
  private Timestamp esdTo;

  private boolean reorderFlag;

  private boolean e911SameAsPPU;

  // XOrders.MASTERORDERS_ID
  private Long masterOrderId;

  private ESIGNDocument eSign;

  private Resubmit resubmit;

  private CreditRiskProfile creditRiskProfile;

  private UCCAdminInfo uCCAdminInfo;

  private List<LegalDocument> legalDocuments = new ArrayList<>();

  private OrderAttribute attributes;

  private OrderQuote quoteToOrder;

  private List<CartShippingInstruct> cartShippingInstruct = new ArrayList<>();

  private List<OrderComment> orderComments = new ArrayList<>();

  private List<OrderBlockDetail> orderBlockDetails = new ArrayList<>();

  private List<Packages> packages = new ArrayList<>();

  private Address shipAddress;

  private Address ppuAddress;

  private Address e911Address;

  private Address billingAddress;

  private Address contactAddress;

}
