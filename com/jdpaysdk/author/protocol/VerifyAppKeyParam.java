package com.jdpaysdk.author.protocol;

public class VerifyAppKeyParam extends BaseRequest {
  private String appKey;
  
  private String merchantNo;
  
  public String getAppKey() {
    return this.appKey;
  }
  
  public String getMerchantNo() {
    return this.merchantNo;
  }
  
  public void setAppKey(String paramString) {
    this.appKey = paramString;
  }
  
  public void setMerchantNo(String paramString) {
    this.merchantNo = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\protocol\VerifyAppKeyParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */