package com._37coins.clx.helper;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com._37coins.clx.helper.api.client.RestAPI;
import com._37coins.clx.helper.api.response.SendSMSResponse;
import com._37coins.clx.helper.exception.ClxException;

public class RestApiTest {

  static RestAPI restApi;
  static boolean inOriginIP; 
  
  @BeforeClass
  static public void before(){
    restApi = new RestAPI("37Coins_gw0","Hi3nGY6p");
    inOriginIP= ( System.getProperties().get("inOriginIP")!=null);
    System.out.println("inOriginIP:"+inOriginIP);
  }
  
  @Test
  public void testBadUser() {
    try {
      RestAPI restApiLocal = new RestAPI("baduser","Hi3nGY6p");
      SendSMSResponse resp = restApiLocal.sendSMS("12", "11", "aers", null);
      assertEquals(false,resp.messageAccepted());
      assertEquals(401,resp.getStatusCode());
      assertEquals("Incorrect account or password",resp.getMessageID());
    } catch (ClxException e) {
      e.printStackTrace();
      fail("exception");
    }
  }
  
  @Test
  public void testBadUserNoSSL() {
    try {
      RestAPI restApiLocal = new RestAPI("baduser","Hi3nGY6p",false);
      SendSMSResponse resp = restApiLocal.sendSMS("12", "11", "aers", null);
      assertEquals(false,resp.messageAccepted());
      assertEquals(401,resp.getStatusCode());
      assertEquals("Incorrect account or password",resp.getMessageID());
    } catch (ClxException e) {
      e.printStackTrace();
      fail("exception");
    }
  }
  
  
  @Test 
  public void testBadPassword() {
    if(inOriginIP){
      try {
        RestAPI restApiLocal = new RestAPI("37Coins_gw0","badpassword");
        SendSMSResponse resp = restApiLocal.sendSMS("12", "11", "aers", null);
        assertEquals(false,resp.messageAccepted());
        assertEquals(401,resp.getStatusCode());
        assertEquals("Incorrect account or password",resp.getMessageID());
      } catch (ClxException e) {
        e.printStackTrace();
        fail("exception");
      }
    }
  }

  
  @Test
  public void testSendSMS() {
    if(inOriginIP){
      try {
        SendSMSResponse resp = restApi.sendSMS("12", "11", "aers", null);
        System.out.println("code:"+resp.getStatusCode());
        System.out.println("mess:"+resp.getMessageID());
        assertEquals(false,resp.messageAccepted());
        assertEquals(403,resp.getStatusCode());
        assertEquals("To number Incorrect account or password",resp.getMessageID());
      } catch (ClxException e) {
        e.printStackTrace();
        fail("exception");
      }
    }
    
  }

}
