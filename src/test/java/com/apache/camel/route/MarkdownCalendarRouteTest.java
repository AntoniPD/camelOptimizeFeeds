package com.apache.camel.route;

import java.io.File;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
public class MarkdownCalendarRouteTest {
  @Autowired
  private ProducerTemplate producerTemplate;

  @Test
  public void testCreateCsvFile() throws InterruptedException {
    String message = "event_id|fisc_year|mkdwn1_eff_date|mkdwn2_eff_date|mkdwn3_eff_date|mkdwn4_eff_date|mkdwn5_eff_date|mkdwn6_eff_date|out_of_sale_eff_date|event_type_code\n"
        + "76|2008|2008-12-01 00:00:00|2008-12-22 00:00:00|2009-02-23 00:00:00|2009-03-23 00:00:00||||CMD";
    String fileName = "fileTest.csv";
    producerTemplate.sendBodyAndHeader("file:data/output", message, Exchange.FILE_NAME, fileName);

    Thread.sleep(3000);
    File outFile = new File("data/output/" +fileName);
    Assert.assertTrue("File doesnt exist", outFile.exists());
  }

  @After
  public void deleteFiles() {
        String fileName = "fileTest.csv";

        File outFile = new File("data/output/" +fileName);

        outFile.delete();

  }
}
