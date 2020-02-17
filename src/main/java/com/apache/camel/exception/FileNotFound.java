package com.apache.camel.exception;

public class FileNotFound extends RuntimeException {
  public FileNotFound(String message) {
    super(message);
  }
}
