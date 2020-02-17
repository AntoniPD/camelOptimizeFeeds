package com.apache.camel.utils;

import com.apache.camel.exception.NotValidFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class HttpRequestParser {
  private static final Pattern SPLITTER = Pattern.compile("\\.");
  private static final String START_FILE = "Response Body";
  private static final String END_FILE = "Response Code";

  public static void convertTxtToJson() {
    File dir = new File("data/input_calendar");
    File[] listOfFiles = dir.listFiles();

    if (listOfFiles.length > 0) {
      Arrays.stream(listOfFiles).forEach(file -> {
        String fileName = file.getName();
        try {
          readFile(fileName);
        } catch (NotValidFile | FileNotFoundException notValidFile) {
          log.error(notValidFile.getMessage());
        }
      });
    }
  }

  private static void readFile(String name) throws NotValidFile, FileNotFoundException {
    if (!name.contains(".txt")) {
      throw new NotValidFile("Given file is not a txt file.");
    }
      String textName = SPLITTER.split(name)[0];
      File input = new File("data/input_calendar/" + name);
    if (input.length() == 0) {
      throw new NotValidFile("Given file is empty");
    }
      File output = new File("data/mkdwn_calendar/" + textName + ".json");
      Scanner sc = new Scanner(input);
      PrintWriter printer = new PrintWriter(output);
      boolean started = false;
      while (sc.hasNextLine()) {
        String s = sc.nextLine();
        if (!started && s.contains(START_FILE)) {
          started = true;
          continue;
        }

        if (started && s.contains(END_FILE)) {
          break;
        }

        if (started) {
          printer.write(s);
          printer.write('\n');
        }
      }
      sc.close();
    printer.close();
    input.delete();
    if (!started) {
      output.delete();
      throw new NotValidFile("Given text file is not with the right format!");
    }
  }

  public static boolean checkIfFileExists(String name) {
    File file = new File("data/mkdwn_calendar/" + SPLITTER.split(name)[0] + ".json" );
    return file.exists();
  }
}
