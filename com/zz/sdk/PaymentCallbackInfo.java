package com.zz.sdk;

public class PaymentCallbackInfo {
  public static final int STATUS_CANBEL = -3;
  
  public static final int STATUS_CANCEL = -2;
  
  public static final int STATUS_FAILURE = -1;
  
  public static final int STATUS_SUCCESS = 0;
  
  public String amount;
  
  public String currency;
  
  public String gameOrderNumber;
  
  public String payWayName;
  
  public int payWayType;
  
  public int statusCode;
  
  public String submitTime;
  
  public String toString() {
    return "PaymentCallbackInfo [statusCode=" + this.statusCode + ", amount=" + this.amount + ", gameOrderNumber=" + this.gameOrderNumber + ", submitTime=" + this.submitTime + "(" + this.submitTime + "), payWay=" + this.payWayName + "(" + this.payWayType + "), currency=" + this.currency + "]";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\PaymentCallbackInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */