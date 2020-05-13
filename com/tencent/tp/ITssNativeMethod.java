package com.tencent.tp;

import java.io.UnsupportedEncodingException;

public interface ITssNativeMethod {
  void forceExit();
  
  int hasMatchRate(int paramInt);
  
  int isRookitRunning();
  
  int isToastEnabled();
  
  void loadConfig(Object paramObject);
  
  void loadMalwareScanInfo(Object paramObject);
  
  void loadMessageBoxInfo(Object paramObject);
  
  void loadRootkitTipStr(Object paramObject);
  
  void onRuntimeInfo(String paramString) throws UnsupportedEncodingException;
  
  void sendStringToSvr(String paramString) throws UnsupportedEncodingException;
  
  void setcancelupdaterootkit();
  
  void setrootkittipstate(int paramInt);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\ITssNativeMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */