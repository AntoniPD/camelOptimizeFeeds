package com.apache.camel.processor;

import com.apache.camel.domain.markdown_calendar.MarkdownCalendarCsv;
import com.apache.camel.domain.markdown_calendar.MarkdownCalendarJson;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

@Service
public class MarkdownCalendarProcessor implements Processor {
  @Override
  public void process(Exchange exchange) throws Exception {
    List<MarkdownCalendarJson> list = (List<MarkdownCalendarJson>) exchange.getIn().getBody();
    List<MarkdownCalendarCsv> markdownCalendarCsvs = new ArrayList<>();
    list.forEach(markDownCalendarJson -> {
      MarkdownCalendarCsv markdownCalendarCsv = new MarkdownCalendarCsv();
      markdownCalendarCsv.setEventId(markDownCalendarJson.getPriceChangeEventId());
      markdownCalendarCsv.setFiscYear(markDownCalendarJson.getFyrNbr());
      // TODO: refactor those ifs somehow
      markDownCalendarJson.getPriceChangeEvenMarks().forEach(priceChangeEvenMarks -> {
        switch (priceChangeEvenMarks.getPriceChangeEventMarkNbr()) {
          case 1:
            markdownCalendarCsv.setMkdwn1EffDate(markDownCalendarJson.getMarkStartDateByPriceChangeNbr(1));
            break;
          case 2:
            markdownCalendarCsv.setMkdwn2EffDate(markDownCalendarJson.getMarkStartDateByPriceChangeNbr(2));
            break;
          case 3:
            markdownCalendarCsv.setMkdwn3EffDate(markDownCalendarJson.getMarkStartDateByPriceChangeNbr(3));
            break;
          case 4:
            markdownCalendarCsv.setMkdwn4EffDate(markDownCalendarJson.getMarkStartDateByPriceChangeNbr(4));
            break;
          case 5:
            markdownCalendarCsv.setMkdwn5EffDate(markDownCalendarJson.getMarkStartDateByPriceChangeNbr(5));
            break;
          case 6:
            markdownCalendarCsv.setMkdwn6EffDate(markDownCalendarJson.getMarkStartDateByPriceChangeNbr(6));
            break;
          case 7:
            markdownCalendarCsv.setOutOfSaleEffDate(markDownCalendarJson.getMarkStartDateByPriceChangeNbr(7));
            break;
          default:
        }
      });
      markdownCalendarCsv.setEventTypeCode(markDownCalendarJson.getPriceChangeEventTypeCode());
      markdownCalendarCsvs.add(markdownCalendarCsv);
    });
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    String localDateTime = LocalDateTime.now().format(formatter);
    exchange.getIn().setHeader("filename", localDateTime);
    exchange.getIn().setBody(markdownCalendarCsvs);
  }
}
