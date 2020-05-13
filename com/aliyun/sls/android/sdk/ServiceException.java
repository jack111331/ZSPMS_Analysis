package com.aliyun.sls.android.sdk;

public class ServiceException extends Exception {
  private static final long serialVersionUID = 430933593095358673L;
  
  private String errorCode;
  
  private String hostId;
  
  private String rawMessage;
  
  private String requestId;
  
  private int statusCode;
  
  public ServiceException(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    super(paramString1);
    this.statusCode = paramInt;
    this.errorCode = paramString2;
    this.requestId = paramString3;
    this.hostId = paramString4;
    this.rawMessage = paramString5;
  }
  
  public String getErrorCode() {
    return this.errorCode;
  }
  
  public String getHostId() {
    return this.hostId;
  }
  
  public String getRawMessage() {
    return this.rawMessage;
  }
  
  public String getRequestId() {
    return this.requestId;
  }
  
  public int getStatusCode() {
    return this.statusCode;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[StatusCode]: ");
    stringBuilder.append(this.statusCode);
    stringBuilder.append(", [Code]: ");
    stringBuilder.append(getErrorCode());
    stringBuilder.append(", [Message]: ");
    stringBuilder.append(getMessage());
    stringBuilder.append(", [Requestid]: ");
    stringBuilder.append(getRequestId());
    stringBuilder.append(", [HostId]: ");
    stringBuilder.append(getHostId());
    stringBuilder.append(", [RawMessage]: ");
    stringBuilder.append(getRawMessage());
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\ServiceException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */