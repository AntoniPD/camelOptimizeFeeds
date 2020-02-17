package com.apache.camel.domain.markdown_candidate;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

// TODO: Finish the Formatted file
@CsvRecord(separator = "\\|", generateHeaderColumns = true)
public class MarkdownCandidateFormatted {

  @DataField(pos = 1, columnName = "event_id")
  private String eventId;

  @DataField(pos = 2, columnName = "sku_id")
  private String skuId;

  @DataField(pos = 3, columnName = "node_key")
  private String nodeKey;

  @DataField(pos = 4, columnName = "SKU_LOC_STATUS_CODE")
  private String skuLocStatusCode;

  @DataField(pos = 5, columnName = "sku_store_mkdwn_rtl_price")
  private String skuStorePrice;

  @DataField(pos = 6, columnName = "source_create_date")
  private String sourceCreateDate;

  @DataField(pos = 7, columnName = "mkdwn_eff_date")
  private String mkdwnEffDate;

  @DataField(pos = 8, columnName = "sku_store_mkdwn_perc")
  private String skuStoreMkdwnPerc;

  @Override
  public String toString() {
    return "MarkdownCandidateFormatted{" +
            "eventId='" + eventId + '\'' +
            ", skuId='" + skuId + '\'' +
            ", nodeKey='" + nodeKey + '\'' +
            ", skuLocStatusCode='" + skuLocStatusCode + '\'' +
            ", skuStorePrice='" + skuStorePrice + '\'' +
            ", sourceCreateDate='" + sourceCreateDate + '\'' +
            ", mkdwnEffDate='" + mkdwnEffDate + '\'' +
            ", skuStoreMkdwnPerc='" + skuStoreMkdwnPerc + '\'' +
            '}';
  }

  public String getEventId() {
    return eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public String getSkuId() {
    return skuId;
  }

  public void setSkuId(String skuId) {
    this.skuId = skuId;
  }

  public String getNodeKey() {
    return nodeKey;
  }

  public void setNodeKey(String nodeKey) {
    this.nodeKey = nodeKey;
  }

  public String getSkuLocStatusCode() {
    return skuLocStatusCode;
  }

  public void setSkuLocStatusCode(String skuLocStatusCode) {
    this.skuLocStatusCode = skuLocStatusCode;
  }

  public String getSkuStorePrice() {
    return skuStorePrice;
  }

  public void setSkuStorePrice(String skuStorePrice) {
    this.skuStorePrice = skuStorePrice;
  }

  public String getSourceCreateDate() {
    return sourceCreateDate;
  }

  public void setSourceCreateDate(String sourceCreateDate) {
    this.sourceCreateDate = sourceCreateDate;
  }

  public String getMkdwnEffDate() {
    return mkdwnEffDate;
  }

  public void setMkdwnEffDate(String mkdwnEffDate) {
    this.mkdwnEffDate = mkdwnEffDate;
  }

  public String getSkuStoreMkdwnPerc() {
    return skuStoreMkdwnPerc;
  }

  public void setSkuStoreMkdwnPerc(String skuStoreMkdwnPerc) {
    this.skuStoreMkdwnPerc = skuStoreMkdwnPerc;
  }
}
