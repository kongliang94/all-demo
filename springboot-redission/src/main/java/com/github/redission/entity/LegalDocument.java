package com.github.redission.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class LegalDocument {

  // XOrdersAttrs.legalDocuments_docId_2
  private Long documentId;

  // XOrdersAttrs.
  // to be made an enum[After discussion]
  private String documentType;

  // XOrdersAttrs.legalDocuments_acceptedDateTime_2
  private Timestamp acceptedDateTime;

  // XOrdersAttrs.legalDocuments_ingestedDocumentID_1
  private Long ingestedDocumentId;
}
