package com.apache.camel.domain.markdown_calendar;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@JsonDeserialize
public class MarkdownCalendarJson {
  private String priceChangeEventId;

  private String priceChangeEventTypeCode;

  private String fyrNbr;

  private List<PriceChangeEvenMarks> priceChangeEvenMarks;

  public String getPriceChangeEventId() {
    return priceChangeEventId;
  }

  public void setPriceChangeEventId(String priceChangeEventId) {
    this.priceChangeEventId = priceChangeEventId;
  }

  public String getPriceChangeEventTypeCode() {
    return priceChangeEventTypeCode;
  }

  public void setPriceChangeEventTypeCode(String priceChangeEventTypeCode) {
    this.priceChangeEventTypeCode = priceChangeEventTypeCode;
  }

  public String getFyrNbr() {
    return fyrNbr;
  }

  public void setFyrNbr(String fyrNbr) {
    this.fyrNbr = fyrNbr;
  }

  public List<PriceChangeEvenMarks> getPriceChangeEvenMarks() {
    return Collections.unmodifiableList(priceChangeEvenMarks);
  }

  public String getMarkStartDateByPriceChangeNbr(int priceChangeEventNbr) {
    return priceChangeEvenMarks.stream()
        .filter(priceChangeEvenMarks1 -> priceChangeEvenMarks1.getPriceChangeEventMarkNbr() == priceChangeEventNbr)
        .collect(Collectors.toList())
        .get(0)
        .getMarkStartDate();
  }

  public void setPriceChangeEvenMarks(List<PriceChangeEvenMarks> priceChangeEvenMarks) {
      this.priceChangeEvenMarks = priceChangeEvenMarks;
  }

  @Override
  public String toString() {
    return "MarkdownCalendarJson{" +
        "priceChangeEventId='" + priceChangeEventId + '\'' +
        ", priceChangeEventTypeCode='" + priceChangeEventTypeCode + '\'' +
        ", fyrNbr='" + fyrNbr + '\'' +
        ", priceChangeEvenMarks=" + priceChangeEvenMarks +
        '}';
  }
}
