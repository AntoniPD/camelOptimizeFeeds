package com.apache.camel.route;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(CamelSpringBootRunner.class)
public class DeleteArchiveRouteTest {

  @Autowired
  private ProducerTemplate producerTemplate;

  protected RouteBuilder createRouteBuilder() throws Exception {
    return new DeleteArchiveRoute();
  }

  @Before
  public void createFile() throws IOException {
    File newFile = new File("data/archive/test.txt");
    newFile.createNewFile();
    newFile.setLastModified(1L);
  }

  @Test
  public void test() throws Exception {
    File directory = new File("data/archive");
    Assert.assertEquals(directory.listFiles().length, 1);
    producerTemplate.start();
    Thread.sleep(60000);

    Assert.assertEquals(directory.listFiles().length, 0);
  }


}
