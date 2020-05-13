package com.aliyun.sls.android.sdk.core;

import java.util.Map;

public class Result {
  private String requestId;
  
  private Map<String, String> responseHeader;
  
  private int statusCode;
  
  public String getRequestId() {
    return this.requestId;
  }
  
  public Map<String, String> getResponseHeader() {
    return this.responseHeader;
  }
  
  public int getStatusCode() {
    return this.statusCode;
  }
  
  public void setRequestId(String paramString) {
    this.requestId = paramString;
  }
  
  public void setResponseHeader(Map<String, String> paramMap) {
    this.responseHeader = paramMap;
  }
  
  public void setStatusCode(int paramInt) {
    this.statusCode = paramInt;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\core\Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */