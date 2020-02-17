package com.apache.camel.domain.markdown_candidate;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
// TEST FILE
@CsvRecord(separator = "\\|", skipFirstLine = true)
public class MarkdownCandidateCsv {
  @DataField(pos = 1)
  private String reasonCode;

  @DataField(pos = 2)
  private String item;

  @DataField(pos = 3)
  private String skulist;

  @DataField(pos = 4)
  private String diffId;

  @DataField(pos = 5)
  private String zoneNodeType;

  @DataField(pos = 6)
  private String zoneGroupDisplayId;

  @DataField(pos = 7)
  private String zoneId;

  @DataField(pos = 8)
  private String effectiveDate;

  @DataField(pos = 9)
  private String outOfStockDate;

  @DataField(pos = 10)
  private String resetDate;

  @DataField(pos = 11)
  private String changeType;

  @DataField(pos = 12)
  private String changeAmount;

  @DataField(pos = 13)
  private String changePercent;

  @DataField(pos = 14)
  private String priceGuideId;

  @DataField(pos = 15)
  private String actnCde;

  @DataField(pos = 16)
  private String priorityInd;

  @DataField(pos = 17)
  private String extrctDate;

  @DataField(pos = 18)
  private String allDoorInd;

  public String getReasonCode() {
    return reasonCode;
  }

  public void setReasonCode(String reasonCode) {
    this.reasonCode = reasonCode;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getSkulist() {
    return skulist;
  }

  public void setSkulist(String skulist) {
    this.skulist = skulist;
  }

  public String getDiffId() {
    return diffId;
  }

  public void setDiffId(String diffId) {
    this.diffId = diffId;
  }

  public String getZoneNodeType() {
    return zoneNodeType;
  }

  public void setZoneNodeType(String zoneNodeType) {
    this.zoneNodeType = zoneNodeType;
  }

  public String getZoneGroupDisplayId() {
    return zoneGroupDisplayId;
  }

  public void setZoneGroupDisplayId(String zoneGroupDisplayId) {
    this.zoneGroupDisplayId = zoneGroupDisplayId;
  }

  public String getZoneId() {
    return zoneId;
  }

  public void setZoneId(String zoneId) {
    this.zoneId = zoneId;
  }

  public String getEffectiveDate() {
    return effectiveDate;
  }

  public void setEffectiveDate(String effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  public String getOutOfStockDate() {
    return outOfStockDate;
  }

  public void setOutOfStockDate(String outOfStockDate) {
    this.outOfStockDate = outOfStockDate;
  }

  public String getResetDate() {
    return resetDate;
  }

  public void setResetDate(String resetDate) {
    this.resetDate = resetDate;
  }

  public String getChangeType() {
    return changeType;
  }

  public void setChangeType(String changeType) {
    this.changeType = changeType;
  }

  public String getChangeAmount() {
    return changeAmount;
  }

  public void setChangeAmount(String changeAmount) {
    this.changeAmount = changeAmount;
  }

  public String getChangePercent() {
    return changePercent;
  }

  public void setChangePercent(String changePercent) {
    this.changePercent = changePercent;
  }

  public String getPriceGuideId() {
    return priceGuideId;
  }

  public void setPriceGuideId(String priceGuideId) {
    this.priceGuideId = priceGuideId;
  }

  public String getActnCde() {
    return actnCde;
  }

  public void setActnCde(String actnCde) {
    this.actnCde = actnCde;
  }

  public String getPriorityInd() {
    return priorityInd;
  }

  public void setPriorityInd(String priorityInd) {
    this.priorityInd = priorityInd;
  }

  public String getExtrctDate() {
    return extrctDate;
  }

  public void setExtrctDate(String extrctDate) {
    this.extrctDate = extrctDate;
  }

  public String getAllDoorInd() {
    return allDoorInd;
  }

  public void setAllDoorInd(String allDoorInd) {
    this.allDoorInd = allDoorInd;
  }

  @Override
  public String toString() {
    return "MarkdownCandidateCsv{" +
        "reasonCode='" + reasonCode + '\'' +
        ", item='" + item + '\'' +
        ", skulist='" + skulist + '\'' +
        ", diffId='" + diffId + '\'' +
        ", zoneNodeType='" + zoneNodeType + '\'' +
        ", zoneGroupDisplayId='" + zoneGroupDisplayId + '\'' +
        ", zoneId='" + zoneId + '\'' +
        ", effectiveDate='" + effectiveDate + '\'' +
        ", outOfStockDate='" + outOfStockDate + '\'' +
        ", resetDate='" + resetDate + '\'' +
        ", changeType='" + changeType + '\'' +
        ", changeAmount='" + changeAmount + '\'' +
        ", changePercent='" + changePercent + '\'' +
        ", priceGuideId='" + priceGuideId + '\'' +
        ", actnCde='" + actnCde + '\'' +
        ", priorityInd='" + priorityInd + '\'' +
        ", extrctDate='" + extrctDate + '\'' +
        ", allDoorInd='" + allDoorInd + '\'' +
        '}';
  }
}
