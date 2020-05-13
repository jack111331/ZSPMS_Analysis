package com.unionpay;

public final class UPSEInfoResp {
  public static String ERROR_NONE;
  
  public static String ERROR_NOT_READY;
  
  public static String ERROR_NOT_SUPPORT;
  
  public static int PARAM_ERROR;
  
  public static String READY = "00";
  
  public static int SUCCESS;
  
  static {
    ERROR_NOT_SUPPORT = "01";
    ERROR_NOT_READY = "02";
    ERROR_NONE = "03";
    SUCCESS = 0;
    PARAM_ERROR = 1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\UPSEInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */