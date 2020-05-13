package com.aliyun.sls.android.sdk;

public class ClientException extends Exception {
  private Boolean canceled = Boolean.valueOf(false);
  
  public ClientException() {}
  
  public ClientException(String paramString) {
    super(stringBuilder.toString());
  }
  
  public ClientException(String paramString, Throwable paramThrowable) {
    this(paramString, paramThrowable, Boolean.valueOf(false));
  }
  
  public ClientException(String paramString, Throwable paramThrowable, Boolean paramBoolean) {
    super(stringBuilder.toString(), paramThrowable);
    this.canceled = paramBoolean;
  }
  
  public ClientException(Throwable paramThrowable) {
    super(paramThrowable);
  }
  
  public String getMessage() {
    String str = super.getMessage();
    if (getCause() != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getCause().getMessage());
      stringBuilder.append("\n");
      stringBuilder.append(str);
      str = stringBuilder.toString();
    } 
    return str;
  }
  
  public Boolean isCanceledException() {
    return this.canceled;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\ClientException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */