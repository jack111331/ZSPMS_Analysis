package com.tencent.tp;

public class TssSdk {
  public static final String TSS_SDK_VERSION = "4.2.20(2019/11/28)-jar-version";
  
  static {
    System.loadLibrary("tersafe2");
  }
  
  public static String decTssInfo(String paramString) {
    return ioctl(String.format("dec_tss_info:%s", new Object[] { paramString }));
  }
  
  public static native void forceExit();
  
  public static native int getsdkantidata(TssIOCtlResult paramTssIOCtlResult);
  
  public static native int hasMatchRate(int paramInt);
  
  public static native void init(TssSdkInitInfo paramTssSdkInitInfo);
  
  public static String ioctl(String paramString) {
    if (paramString == null || paramString.length() == 0)
      return null; 
    TssIOCtlResult tssIOCtlResult = new TssIOCtlResult();
    tssIOCtlResult.cmd = paramString;
    return (getsdkantidata(tssIOCtlResult) != 0) ? null : tssIOCtlResult.response;
  }
  
  public static native int isRookitRunning();
  
  public static native int isToastEnabled();
  
  public static native void loadConfig(Object paramObject);
  
  public static native void loadMalwareScanInfo(Object paramObject);
  
  public static native void loadMessageBoxInfo(Object paramObject);
  
  public static native void loadRootkitTipStr(Object paramObject);
  
  public static native void onruntimeinfo(byte[] paramArrayOfbyte, int paramInt);
  
  public static void registTssInfoReceiver(TssInfoPublisher.TssInfoReceiver paramTssInfoReceiver) {
    TssInfoPublisher.a().a(paramTssInfoReceiver);
  }
  
  public static native void senddatatosdk(byte[] paramArrayOfbyte, int paramInt);
  
  public static native void senddatatosvr(byte[] paramArrayOfbyte, int paramInt);
  
  public static native void setcancelupdaterootkit();
  
  public static native void setgamestatus(TssSdkGameStatusInfo paramTssSdkGameStatusInfo);
  
  public static native void setrootkittipstate(int paramInt);
  
  public static native void setsenddatatosvrcb(ISendDataToSvr paramISendDataToSvr);
  
  public static native void setuserinfo(TssSdkUserInfo paramTssSdkUserInfo);
  
  public static native void setuserinfoex(TssSdkUserInfoEx paramTssSdkUserInfoEx);
  
  public static interface ISendDataToSvr {
    int sendDataToSvr(byte[] param1ArrayOfbyte, int param1Int);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\TssSdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */