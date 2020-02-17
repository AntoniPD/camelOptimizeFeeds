package com.apache.camel.route;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
@RunWith(CamelSpringBootRunner.class)
public class MarkDownCandidateRouteTest {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Test
    public void createMarkdownFileTest() throws InterruptedException {
        String message = "REASON_CODE|ITEM|SKULIST|Diff_ID|ZONE_NODE_TYPE|ZONE_GROUP_DISPLAY__ID|ZONE_ID/LOCATION|EFFECTIVE_DATE|OUT_OF_STOCK_DATE|RESET_DATE|CHANGE_TYPE|CHANGE_AMOUNT|CHANGE_PERCENT|PRICE_GUIDE_ID|ACTN_CDE|PRIORITY_IND|EXTRCT_DATE|ALL_DOOR_IND\n" +
                "414-CMD-19-2016-27--1|19617786|||0|5000|1506|07/31/2016|||2|11.2000|||ADD|2|04/10/2016 14:00:22|N";
        String fileName = "fileTest.csv";

        producerTemplate.sendBodyAndHeader("file:data/output", message, Exchange.FILE_NAME, fileName);

        Thread.sleep(3000);

        File outFile = new File("data/output/" + fileName);
        Assert.assertTrue("File doesnt exist", outFile.exists());

    }

    @After
    public void deleteFiles() {
        String fileName = "fileTest.csv";

        File outFile = new File("data/output/" + fileName);

        outFile.delete();

    }
}
