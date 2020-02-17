package com.apache.camel.exception;

public class NotValidFile extends Exception {
  private String message;

  public NotValidFile(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
