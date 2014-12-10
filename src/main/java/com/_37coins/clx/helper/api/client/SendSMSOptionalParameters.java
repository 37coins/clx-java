package com._37coins.clx.helper.api.client;

public class SendSMSOptionalParameters {

  /**
   * Charset of text message.
   *
   * Used to convert to a format suitable for 7-bit or UCS2. Defaults to ISO-8859-1 if coding is 7-bit and UTF16BE if coding is UCS2
   */
  private String charset;
  
  /**
   * Optional User Data Header (UDH) part of the message.
   */
  private String udh;
  
  /**
   * Sets the Message Class in DCS Field.
   *
   * Accepts values between 0 and 3.
   *
   * 0 = Sends the message directly to display
   * 1 = Sends to mobile
   * 2 = Sends to SIM
   * 3 = Sends to SIM Toolkit
   */
  private Integer mclass;
  
  /**
   * Sets Message Waiting Indicator bits in the DCS field. 
   * If given, the message will be encoded as Message Waiting Indicator. 
   * The accepted values are 0, 1, 2, 3 for activating the voice, fax, e-mail and other indicator. 
   * Or 4, 5, 6, 7 for deactivating respectively.
   */
  private Integer mwi;
  
  /**
   * Sets the coding scheme bits in DCS field.
   *
   * Accepts values between 0 and 2.
   *
   * 0 = 7-bit
   * 1 = 8-bit
   * 2 = UCS2
   * 
   * If unset, defaults to 7-bit unless a UDH is defined, which sets coding to 8-bit.
   */
  private Integer coding;
  
  /**
   * If given, CLX will only try to send the message for this many minutes. 
   * If the destination mobile is unreachable the SMSC discards the message
   */
  private Integer validity;
  
  /**
   * If given, the message will be postponed to be delivered at now plus this many minutes
   */
  private Integer defered;
  
  /**
   * Request for delivery reports with the state of the sent message. The value is a bit mask composed of:
   * 
   * 1 = Delivered to phone
   * 2 = Non-delivered to Phone
   * 4 = Queued on SMSC
   * 8 = Delivered to SMSC
   * 16 = Non-delivered to SMSC
   * 
   * If you want multiple report types, you simply add the values together. 
   * For example if you want to get delivery (1) and non-delivery (2) you set the dlr-mask value to 3 (1+2). 
   * If given, dlr-url must be given as well.
   */
  private Integer dlr_mask;
  
  /**
   * If dlr-mask is given, this is the URL to be fetched.
   */
  private String dlr_url;
   
  /**
   * Sets the PID value [2]. For example, a SIM Toolkit message would use something like the following:
   * 
   * &pid=127&coding=2&alt-dcs=1&mclass=3
   * 
   */
  private Integer pid;
  
  /**
   * If unset, 0X per default.
   * 
   * 1= uses FX.
   * 2 = force 0X
   */
  private Integer alt_dcs;
  
  /**
   * A user provided identity of the message. 
   * If DLR is requested it will be possible to have this user provided identity included Integero DLR-URL. 
   * Maximum length of this field is 32 bytes.
   */
  private String id;

  public String getCharset() {
    return charset;
  }

  public SendSMSOptionalParameters setCharset(String charset) {
    this.charset = charset;
    return this;
  }

  public String getUdh() {
    return udh;
  }

  public SendSMSOptionalParameters setUdh(String udh) {
    this.udh = udh;
    return this;
  }

  public Integer getMclass() {
    return mclass;
  }

  public SendSMSOptionalParameters setMclass(Integer mclass) {
    this.mclass = mclass;
    return this;
  }

  public Integer getMwi() {
    return mwi;
  }

  public SendSMSOptionalParameters setMwi(Integer mwi) {
    this.mwi = mwi;
    return this;
  }

  public Integer getCoding() {
    return coding;
  }

  public SendSMSOptionalParameters setCoding(Integer coding) {
    this.coding = coding;
    return this;
  }

  public Integer getValidity() {
    return validity;
  }

  public SendSMSOptionalParameters setValidity(Integer validity) {
    this.validity = validity;
    return this;
  }

  public Integer getDefered() {
    return defered;
  }

  public SendSMSOptionalParameters setDefered(Integer defered) {
    this.defered = defered;
    return this;
  }

  public Integer getDlr_mask() {
    return dlr_mask;
  }

  public SendSMSOptionalParameters setDlr_mask(Integer dlr_mask) {
    this.dlr_mask = dlr_mask;
    return this;
  }

  public String getDlr_url() {
    return dlr_url;
  }

  public SendSMSOptionalParameters setDlr_url(String dlr_url) {
    this.dlr_url = dlr_url;
    return this;
  }

  public Integer getPid() {
    return pid;
  }

  public SendSMSOptionalParameters setPid(Integer pid) {
    this.pid = pid;
    return this;
  }

  public Integer getAlt_dcs() {
    return alt_dcs;
  }

  public SendSMSOptionalParameters setAlt_dcs(Integer alt_dcs) {
    this.alt_dcs = alt_dcs;
    return this;
  }

  public String getId() {
    return id;
  }

  public SendSMSOptionalParameters setId(String id) {
    this.id = id;
    return this;
  }
  
  
  
}
