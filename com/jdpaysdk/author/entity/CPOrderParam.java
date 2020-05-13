package com.jdpaysdk.author.entity;

import java.io.Serializable;

public class CPOrderParam implements Serializable {
  private String merchant;
  
  private String orderId;
  
  private String signData;
  
  private String thirdAppKey;
  
  public String getKey() {
    return this.thirdAppKey;
  }
  
  public String getMerchant() {
    return this.merchant;
  }
  
  public String getOrderId() {
    return this.orderId;
  }
  
  public String getSignData() {
    return this.signData;
  }
  
  public String getThirdAppKey() {
    return this.thirdAppKey;
  }
  
  public void setKey(String paramString) {
    this.thirdAppKey = paramString;
  }
  
  public void setMerchant(String paramString) {
    this.merchant = paramString;
  }
  
  public void setOrderId(String paramString) {
    this.orderId = paramString;
  }
  
  public void setSignData(String paramString) {
    this.signData = paramString;
  }
  
  public void setThirdAppKey(String paramString) {
    this.thirdAppKey = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\entity\CPOrderParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */