package com.tencent.tp;

import java.io.UnsupportedEncodingException;

public class TssNativeMethodImp implements ITssNativeMethod {
  public void forceExit() {
    TssSdk.forceExit();
  }
  
  public int hasMatchRate(int paramInt) {
    return TssSdk.hasMatchRate(paramInt);
  }
  
  public int isRookitRunning() {
    return TssSdk.isRookitRunning();
  }
  
  public int isToastEnabled() {
    return TssSdk.isToastEnabled();
  }
  
  public void loadConfig(Object paramObject) {
    TssSdk.loadConfig(paramObject);
  }
  
  public void loadMalwareScanInfo(Object paramObject) {
    TssSdk.loadMalwareScanInfo(paramObject);
  }
  
  public void loadMessageBoxInfo(Object paramObject) {
    TssSdk.loadMessageBoxInfo(paramObject);
  }
  
  public void loadRootkitTipStr(Object paramObject) {
    TssSdk.loadRootkitTipStr(paramObject);
  }
  
  public void onRuntimeInfo(String paramString) throws UnsupportedEncodingException {
    byte[] arrayOfByte = paramString.getBytes("utf-8");
    if (arrayOfByte != null && arrayOfByte.length > 0)
      TssSdk.onruntimeinfo(arrayOfByte, arrayOfByte.length); 
  }
  
  public void sendStringToSvr(String paramString) throws UnsupportedEncodingException {
    byte[] arrayOfByte = paramString.getBytes("utf-8");
    if (arrayOfByte != null && arrayOfByte.length > 0)
      TssSdk.senddatatosvr(arrayOfByte, arrayOfByte.length); 
  }
  
  public void setcancelupdaterootkit() {
    TssSdk.setcancelupdaterootkit();
  }
  
  public void setrootkittipstate(int paramInt) {
    TssSdk.setrootkittipstate(paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\TssNativeMethodImp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */