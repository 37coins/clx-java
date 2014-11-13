package com._37coins.clx.helper.api.client;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com._37coins.clx.helper.api.response.SendSMSResponse;
import com._37coins.clx.helper.exception.ClxException;

public class RestAPI {
  private String USER;
  private String PASSWORD;

  private final String CLX_HOST = "sms1.clxnetworks.net";
  private String BaseURI;

  public RestAPI(String user, String password) {
    this.setUp(user,password,true);
  }
  
  public RestAPI(String user, String password, boolean ssl) {
    this.setUp(user,password,ssl);
  }
  
  public void setUp(String user, String password, boolean ssl) {
    USER = user;
    PASSWORD = password;
    if (ssl){
      BaseURI = String.format("https://%s:3801/sendsms?username=%s&password=%s", CLX_HOST, USER,PASSWORD);
    }else{
      BaseURI = String.format("http://%s:3800/sendsms?username=%s&password=%s", CLX_HOST, USER,PASSWORD);
    }
  }

  public SendSMSResponse sendSMS(String from, String to, String text,
      HashMap<String, String> optionalParameters) throws ClxException {
    try {
      if(optionalParameters==null) optionalParameters=new HashMap<String, String>();
      
      String charset;
      if(optionalParameters.containsKey("charset")){
        charset=optionalParameters.get("charset");
      }else{
        charset="UTF-8";
      }
      to=URLEncoder.encode(to,charset);
      text=URLEncoder.encode(text,charset);

      String uri=String.format("%s&from=%s&to=%s&text=text&charset=%s",BaseURI,from,to,text,charset);
      
      System.out.println("uri:"+uri);

      
      HttpGet req = new HttpGet(uri);
      CloseableHttpClient httpclient = HttpClients.createDefault();
      CloseableHttpResponse rsp = httpclient.execute(req);
      
      //Obtener respuesta
      String output = IOUtils.toString(rsp.getEntity().getContent());
      
      SendSMSResponse smsResp = new SendSMSResponse();
      smsResp.setStatusCode(rsp.getStatusLine().getStatusCode());
      smsResp.setMessageID(output);
      
      return smsResp;

    } catch (ClientProtocolException e) {
      throw new ClxException(e.getLocalizedMessage());
    } catch (IOException e) {
      throw new ClxException(e.getLocalizedMessage());
    }
  }

}
