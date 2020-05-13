package com.alipay.android.phone.mrpc.core;

public class RpcException extends RuntimeException {
  private static final long serialVersionUID = -2875437994101380406L;
  
  private int mCode;
  
  private String mMsg;
  
  private String mOperationType;
  
  public RpcException(Integer paramInteger, String paramString) {
    super(a(paramInteger, paramString));
    this.mCode = paramInteger.intValue();
    this.mMsg = paramString;
  }
  
  public RpcException(Integer paramInteger, String paramString, Throwable paramThrowable) {
    super(a(paramInteger, paramString), paramThrowable);
    this.mCode = paramInteger.intValue();
    this.mMsg = paramString;
  }
  
  public RpcException(Integer paramInteger, Throwable paramThrowable) {
    super(paramThrowable);
    this.mCode = paramInteger.intValue();
  }
  
  public RpcException(String paramString) {
    super(paramString);
    this.mCode = 0;
    this.mMsg = paramString;
  }
  
  private static String a(Integer paramInteger, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("RPCException: ");
    if (paramInteger != null)
      stringBuilder.append("[").append(paramInteger).append("]"); 
    stringBuilder.append(" : ");
    if (paramString != null)
      stringBuilder.append(paramString); 
    return stringBuilder.toString();
  }
  
  public int getCode() {
    return this.mCode;
  }
  
  public String getMsg() {
    return this.mMsg;
  }
  
  public String getOperationType() {
    return this.mOperationType;
  }
  
  public void setOperationType(String paramString) {
    this.mOperationType = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\phone\mrpc\core\RpcException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */