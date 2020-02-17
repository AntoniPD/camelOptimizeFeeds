package com.apache.camel.route;

import com.apache.camel.filter.FilterOldFiles;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DeleteArchiveRoute extends RouteBuilder {

  @Override
  public void configure() throws Exception {

    // FOR TEST PURPOSES: 0 * * * * ? = At second :00 of minute :00 of every minute
    // 0 0 * ? * * = At second :00 of minute :00 of every hour
    from("quartz2://deleteArchive?cron=0+*+*+*+*+?")
        .log("Delete Archive route invoked")
        .bean(FilterOldFiles.class, "deleteOldFiles()")
        .log("Delete Archive route ended");
  }
}
