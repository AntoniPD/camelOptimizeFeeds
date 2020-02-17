package com.apache.camel.domain.markdown_calendar;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class PriceChangeEvenMarks {
  private String createDate;

  private String lastUpdatedDate;

  private String markStartDate;

  private int priceChangeEventMarkNbr;

  public PriceChangeEvenMarks() {
    createDate = "";
    lastUpdatedDate = "";
    markStartDate = "";
  }

  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  public String getLastUpdatedDate() {
    return lastUpdatedDate;
  }

  public void setLastUpdatedDate(String lastUpdatedDate) {
    this.lastUpdatedDate = lastUpdatedDate;
  }

  public String getMarkStartDate() {
    return markStartDate;
  }

  public void setMarkStartDate(String markStartDate) {
    this.markStartDate = markStartDate;
  }

  public int getPriceChangeEventMarkNbr() {
    return priceChangeEventMarkNbr;
  }

  public void setPriceChangeEventMarkNbr(int priceChangeEventMarkNbr) {
    this.priceChangeEventMarkNbr = priceChangeEventMarkNbr;
  }

  @Override
  public String toString() {
    return "PriceChangeEvenMarks{" +
        "createDate='" + createDate + '\'' +
        ", lastUpdatedDate='" + lastUpdatedDate + '\'' +
        ", markStartDate='" + markStartDate + '\'' +
        ", priceChangeEventMarkNbr='" + priceChangeEventMarkNbr + '\'' +
        '}';
  }
}
