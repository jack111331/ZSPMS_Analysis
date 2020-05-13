package com.tencent.tp;

public class r implements ITssJavaMethod {
  public void initialize() {
    TssSdkRuntime.initialize2();
  }
  
  public void invokeForceUpdateRootkitAppRequest() {}
  
  public void invokeRootkitAppRequest() {}
  
  public void invokeRootkitIsRunningTip() {}
  
  public void scan() {
    TssSdkSafeScan.scan(true, false, false, false);
  }
  
  public void showMsgBoxEx() {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */