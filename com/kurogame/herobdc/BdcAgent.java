package com.kurogame.herobdc;

import android.app.Activity;
import com.yingxiong.common.ConfigSDK;
import com.yingxiong.recordsdk.RecordSDK;

public class BdcAgent {
  private static Activity mainActivity;
  
  public static String getDeviceId() {
    return ConfigSDK.instance().getDeviceId();
  }
  
  public static void init(Activity paramActivity) {
    mainActivity = paramActivity;
  }
  
  public static void initSdk(String paramString1, String paramString2, String paramString3) {
    RecordSDK.getInstance().init(mainActivity, paramString1, paramString2, paramString3);
  }
  
  public static void toRecordAction(String paramString) {
    RecordSDK.getInstance().toRecordActionByJson(paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\kurogame\herobdc\BdcAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */