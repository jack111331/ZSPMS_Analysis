package com.aliyun.sls.android.sdk;

public class LogException extends Exception {
  private static final long serialVersionUID = -3451945810203597732L;
  
  public Boolean canceled = Boolean.valueOf(false);
  
  private String errorCode;
  
  private String requestId;
  
  public int responseCode = -1111;
  
  public LogException(String paramString1, String paramString2, String paramString3) {
    super(paramString2);
    this.errorCode = paramString1;
    this.requestId = paramString3;
  }
  
  public LogException(String paramString1, String paramString2, Throwable paramThrowable, String paramString3) {
    super(paramString2, paramThrowable);
    this.errorCode = paramString1;
    this.requestId = paramString3;
  }
  
  public String getErrorCode() {
    return this.errorCode;
  }
  
  public String getErrorMessage() {
    return getMessage();
  }
  
  public String getRequestId() {
    return this.requestId;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\LogException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */