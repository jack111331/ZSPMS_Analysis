package com.jdpaysdk.author.protocol;

import java.io.Serializable;

public class VerifyAppKeyResponse implements Serializable {
  private String errorCode;
  
  private String resultCode;
  
  private String resultMsg;
  
  public String getErrorCode() {
    return this.errorCode;
  }
  
  public String getResultCode() {
    return this.resultCode;
  }
  
  public String getResultMsg() {
    return this.resultMsg;
  }
  
  public void setErrorCode(String paramString) {
    this.errorCode = paramString;
  }
  
  public void setResultCode(String paramString) {
    this.resultCode = paramString;
  }
  
  public void setResultMsg(String paramString) {
    this.resultMsg = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\protocol\VerifyAppKeyResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */