package com.tencent.gcloud.tsssdk;

import android.content.Context;
import com.tencent.tp.TssIOCtlResult;
import com.tencent.tp.TssSdk;
import com.tencent.tp.TssSdkGameStatusInfo;
import com.tencent.tp.TssSdkInitInfo;
import com.tencent.tp.TssSdkUserInfo;

public class OneSDK_Tss {
  public static final int ENTRT_ID_FACEBOOK = 3;
  
  public static final int ENTRY_ID_GAMECENTER = 7;
  
  public static final int ENTRY_ID_GOOGLEPLAY = 8;
  
  public static final int ENTRY_ID_LINE = 5;
  
  public static final int ENTRY_ID_MM = 2;
  
  public static final int ENTRY_ID_OTHERS = 99;
  
  public static final int ENTRY_ID_QQ = 1;
  
  public static final int ENTRY_ID_TWITTER = 4;
  
  public static final int ENTRY_ID_VK = 9;
  
  public static final int ENTRY_ID_WHATSAPP = 6;
  
  public static byte[] getReportData() {
    TssIOCtlResult tssIOCtlResult = new TssIOCtlResult();
    tssIOCtlResult.cmd = "get_report_data";
    return (TssSdk.getsdkantidata(tssIOCtlResult) != 0) ? null : tssIOCtlResult.data;
  }
  
  public static void init(Context paramContext, int paramInt) {
    TssSdkInitInfo tssSdkInitInfo = new TssSdkInitInfo();
    tssSdkInitInfo.game_id = paramInt;
    TssSdk.init(tssSdkInitInfo);
  }
  
  public static String ioctl(String paramString) {
    return TssSdk.ioctl(paramString);
  }
  
  public static void onPause() {
    TssSdkGameStatusInfo tssSdkGameStatusInfo = new TssSdkGameStatusInfo();
    tssSdkGameStatusInfo.game_status = 2;
    TssSdk.setgamestatus(tssSdkGameStatusInfo);
  }
  
  public static void onRecvData(byte[] paramArrayOfbyte) {
    TssSdk.senddatatosdk(paramArrayOfbyte, paramArrayOfbyte.length);
  }
  
  public static void onResume() {
    TssSdkGameStatusInfo tssSdkGameStatusInfo = new TssSdkGameStatusInfo();
    tssSdkGameStatusInfo.game_status = 1;
    TssSdk.setgamestatus(tssSdkGameStatusInfo);
  }
  
  public static void setUserInfo(int paramInt, String paramString) {
    TssSdkUserInfo tssSdkUserInfo = new TssSdkUserInfo();
    tssSdkUserInfo.entry_id = paramInt;
    tssSdkUserInfo.uin_type = 2;
    tssSdkUserInfo.uin_str = paramString;
    tssSdkUserInfo.app_id_type = 2;
    tssSdkUserInfo.app_id_str = "";
    TssSdk.setuserinfo(tssSdkUserInfo);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\gcloud\tsssdk\OneSDK_Tss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */