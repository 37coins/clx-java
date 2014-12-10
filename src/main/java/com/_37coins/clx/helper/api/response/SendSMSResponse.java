package com._37coins.clx.helper.api.response;

public class SendSMSResponse {
  
  private String messageID;
  
  private int statusCode;
  

  public String getMessageID() {
    return messageID;
  }

  public void setMessageID(String messageID) {
    this.messageID = messageID;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }
  
  public boolean messageAccepted(){
    return (getStatusCode()==202);
  }
}
