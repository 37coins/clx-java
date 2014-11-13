package com._37coins.clx.helper.exception;

public class ClxException extends Exception {
  private static final long serialVersionUID = 1L;
  private String Message;

  public ClxException(String message) {
    Message = message;
  }

  public String getMessage() {
    return Message;
  }
}
