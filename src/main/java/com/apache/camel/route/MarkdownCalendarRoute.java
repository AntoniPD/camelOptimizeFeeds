package com.apache.camel.route;

import com.apache.camel.domain.markdown_calendar.MarkdownCalendarCsv;
import com.apache.camel.domain.markdown_calendar.MarkdownCalendarJson;
import com.apache.camel.processor.MarkdownCalendarProcessor;
import java.io.FileNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.camel.spi.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MarkdownCalendarRoute extends RouteBuilder {

  @Autowired
  private Environment environment;

  @Autowired
  private MarkdownCalendarProcessor markdownCalendarProcessor;

  @Override
  public void configure() throws Exception {
    JacksonDataFormat jsonDataFormat = new ListJacksonDataFormat(MarkdownCalendarJson.class);
    DataFormat toMarkdownCalendar = new BindyCsvDataFormat(MarkdownCalendarCsv.class);


    onException(HttpOperationFailedException.class)
                .log(LoggingLevel.ERROR, "EXCEPTION: ${exception.toString()}")
                .handled(true);

    errorHandler(deadLetterChannel("mock:catch"));


    // Every 7 days at noon
    from("quartz2://mkdwnCalendarScheduler?cron=0+0+12+*/7+*+?")
        .log("Scheduled job!")
        .to("direct:httpRoute");

    from("direct:httpRoute")
        .log("Http Route started")
        .setHeader(Exchange.HTTP_METHOD).constant(HttpMethod.GET)
        .to("{{mkdwnCalendarInputUrl}}")
        .unmarshal(jsonDataFormat)
        .process(this.markdownCalendarProcessor)
        .marshal(toMarkdownCalendar)
        .to("file:{{mkdwnCalendarOutputFolder}}?fileName=MKDCAL_${header.filename}.csv");
  }
}