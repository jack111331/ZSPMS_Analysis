package com.tencent.tersafe2;

import com.tencent.tp.TssInfoPublisher;
import com.tencent.tp.TssSdk;
import com.tencent.tp.TssSdkGameStatusInfo;
import com.tencent.tp.TssSdkInitInfo;
import com.tencent.tp.TssSdkUserInfoEx;
import com.tencent.tp.u;

public class TP2Sdk {
  public static String decTssInfo(String paramString) {
    return TssSdk.decTssInfo(paramString);
  }
  
  public static int init(int paramInt) {
    TssSdkInitInfo tssSdkInitInfo = new TssSdkInitInfo();
    tssSdkInitInfo.game_id = paramInt;
    TssSdk.init(tssSdkInitInfo);
    return 0;
  }
  
  public static int initEx(int paramInt, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("app_key:");
    stringBuilder.append(paramString);
    u.a(stringBuilder.toString());
    return init(paramInt);
  }
  
  public static String ioctl(String paramString) {
    return TssSdk.ioctl(paramString);
  }
  
  public static int onAppPause() {
    TssSdkGameStatusInfo tssSdkGameStatusInfo = new TssSdkGameStatusInfo();
    tssSdkGameStatusInfo.game_status = 2;
    TssSdk.setgamestatus(tssSdkGameStatusInfo);
    return 0;
  }
  
  public static int onAppResume() {
    TssSdkGameStatusInfo tssSdkGameStatusInfo = new TssSdkGameStatusInfo();
    tssSdkGameStatusInfo.game_status = 1;
    TssSdk.setgamestatus(tssSdkGameStatusInfo);
    return 0;
  }
  
  public static int onUserLogin(int paramInt1, int paramInt2, String paramString1, String paramString2) {
    TssSdkUserInfoEx tssSdkUserInfoEx = new TssSdkUserInfoEx();
    tssSdkUserInfoEx.entry_id = paramInt1;
    tssSdkUserInfoEx.uin_type = 2;
    tssSdkUserInfoEx.uin_int = 0;
    tssSdkUserInfoEx.uin_str = paramString1;
    tssSdkUserInfoEx.app_id_type = 2;
    tssSdkUserInfoEx.app_id_int = 0;
    tssSdkUserInfoEx.app_id_str = "";
    tssSdkUserInfoEx.world_id = paramInt2;
    tssSdkUserInfoEx.role_id = paramString2;
    TssSdk.setuserinfoex(tssSdkUserInfoEx);
    return 0;
  }
  
  public static void registTssInfoReceiver(TssInfoPublisher.TssInfoReceiver paramTssInfoReceiver) {
    TssSdk.registTssInfoReceiver(paramTssInfoReceiver);
  }
  
  public static int setPopupOptions(int paramInt) {
    return -1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tersafe2\TP2Sdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */