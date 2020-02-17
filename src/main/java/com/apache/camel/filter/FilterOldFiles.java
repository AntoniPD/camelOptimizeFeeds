package com.apache.camel.filter;

import java.io.File;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FilterOldFiles {

  @Autowired
  private Environment environment;

  public void deleteOldFiles() {
    File folder = new File(environment.getProperty("archiveFolderLocation"));
    File[] listOfFiles = folder.listFiles();

    for (File file : listOfFiles) {
      Long timeNow = System.currentTimeMillis();
      Long fileLastChanged = file.lastModified();
      Long timeDelta = timeNow-fileLastChanged;

      if (file.isFile() && timeDelta > environment.getProperty("archiveDuration", Long.class)) {
        file.delete();
        log.info("Deleted old file with name " + file.getName());
      }
    }

  }
}
