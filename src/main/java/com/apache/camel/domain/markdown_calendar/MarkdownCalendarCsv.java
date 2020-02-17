package com.apache.camel.domain.markdown_calendar;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = "\\|", generateHeaderColumns = true)
public class MarkdownCalendarCsv {
  @DataField(pos = 1, columnName = "event_id")
  private String eventId;

  @DataField(pos = 2, columnName = "fisc_year")
  private String fiscYear;

  @DataField(pos = 3, columnName = "mkdwn1_eff_date")
  private String mkdwn1EffDate;

  @DataField(pos = 4, columnName = "mkdwn2_eff_date")
  private String mkdwn2EffDate;

  @DataField(pos = 5, columnName = "mkdwn3_eff_date")
  private String mkdwn3EffDate;

  @DataField(pos = 6, columnName = "mkdwn4_eff_date")
  private String mkdwn4EffDate;

  @DataField(pos = 7, columnName = "mkdwn5_eff_date")
  private String mkdwn5EffDate;

  @DataField(pos = 8, columnName = "mkdwn6_eff_date")
  private String mkdwn6EffDate;

  @DataField(pos = 9, columnName = "out_of_sale_eff_date")
  private String outOfSaleEffDate;

  @DataField(pos = 10, columnName = "event_type_code")
  private String eventTypeCode;

  public String getEventId() {
    return eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public String getFiscYear() {
    return fiscYear;
  }

  public void setFiscYear(String fiscYear) {
    this.fiscYear = fiscYear;
  }

  public String getMkdwn1EffDate() {
    return mkdwn1EffDate;
  }

  public void setMkdwn1EffDate(String mkdwn1EffDate) {
    this.mkdwn1EffDate = mkdwn1EffDate;
  }

  public String getMkdwn2EffDate() {
    return mkdwn2EffDate;
  }

  public void setMkdwn2EffDate(String mkdwn2EffDate) {
    this.mkdwn2EffDate = mkdwn2EffDate;
  }

  public String getMkdwn3EffDate() {
    return mkdwn3EffDate;
  }

  public void setMkdwn3EffDate(String mkdwn3EffDate) {
    this.mkdwn3EffDate = mkdwn3EffDate;
  }

  public String getMkdwn4EffDate() {
    return mkdwn4EffDate;
  }

  public void setMkdwn4EffDate(String mkdwn4EffDate) {
    this.mkdwn4EffDate = mkdwn4EffDate;
  }

  public String getMkdwn5EffDate() {
    return mkdwn5EffDate;
  }

  public void setMkdwn5EffDate(String mkdwn5EffDate) {
    this.mkdwn5EffDate = mkdwn5EffDate;
  }

  public String getMkdwn6EffDate() {
    return mkdwn6EffDate;
  }

  public void setMkdwn6EffDate(String mkdwn6EffDate) {
    this.mkdwn6EffDate = mkdwn6EffDate;
  }

  public String getOutOfSaleEffDate() {
    return outOfSaleEffDate;
  }

  public void setOutOfSaleEffDate(String outOfSaleEffDate) {
    this.outOfSaleEffDate = outOfSaleEffDate;
  }

  public String getEventTypeCode() {
    return eventTypeCode;
  }

  public void setEventTypeCode(String eventTypeCode) {
    this.eventTypeCode = eventTypeCode;
  }

  @Override
  public String toString() {
    return "MarkdownCalendarCsv{" +
        "eventId='" + eventId + '\'' +
        ", fiscYear='" + fiscYear + '\'' +
        ", mkdwn1EffDate='" + mkdwn1EffDate + '\'' +
        ", mkdwn2EffDate='" + mkdwn2EffDate + '\'' +
        ", mkdwn3EffDate='" + mkdwn3EffDate + '\'' +
        ", mkdwn4EffDate='" + mkdwn4EffDate + '\'' +
        ", mkdwn5EffDate='" + mkdwn5EffDate + '\'' +
        ", mkdwn6EffDate='" + mkdwn6EffDate + '\'' +
        ", outOfSaleEffDate='" + outOfSaleEffDate + '\'' +
        ", eventTypeCode='" + eventTypeCode + '\'' +
        '}';
  }
}
