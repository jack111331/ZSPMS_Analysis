package com.tencent.tauth;

public class UiError {
  public int errorCode;
  
  public String errorDetail;
  
  public String errorMessage;
  
  public UiError(int paramInt, String paramString1, String paramString2) {
    this.errorMessage = paramString1;
    this.errorCode = paramInt;
    this.errorDetail = paramString2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tauth\UiError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */