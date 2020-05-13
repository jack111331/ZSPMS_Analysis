package com.tencent.mm.opensdk.diffdev;

public enum OAuthErrCode {
  WechatAuth_Err_Auth_Stopped,
  WechatAuth_Err_Cancel,
  WechatAuth_Err_JsonDecodeErr,
  WechatAuth_Err_NetworkErr,
  WechatAuth_Err_NormalErr,
  WechatAuth_Err_OK(0),
  WechatAuth_Err_Timeout(0);
  
  private int code;
  
  static {
    WechatAuth_Err_NormalErr = new OAuthErrCode("WechatAuth_Err_NormalErr", 1, -1);
    WechatAuth_Err_NetworkErr = new OAuthErrCode("WechatAuth_Err_NetworkErr", 2, -2);
    WechatAuth_Err_JsonDecodeErr = new OAuthErrCode("WechatAuth_Err_JsonDecodeErr", 3, -3);
    WechatAuth_Err_Cancel = new OAuthErrCode("WechatAuth_Err_Cancel", 4, -4);
    WechatAuth_Err_Timeout = new OAuthErrCode("WechatAuth_Err_Timeout", 5, -5);
    WechatAuth_Err_Auth_Stopped = new OAuthErrCode("WechatAuth_Err_Auth_Stopped", 6, -6);
    $VALUES = new OAuthErrCode[] { WechatAuth_Err_OK, WechatAuth_Err_NormalErr, WechatAuth_Err_NetworkErr, WechatAuth_Err_JsonDecodeErr, WechatAuth_Err_Cancel, WechatAuth_Err_Timeout, WechatAuth_Err_Auth_Stopped };
  }
  
  OAuthErrCode(int paramInt1) {
    this.code = paramInt1;
  }
  
  public final int getCode() {
    return this.code;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("OAuthErrCode:");
    stringBuilder.append(this.code);
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\diffdev\OAuthErrCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */