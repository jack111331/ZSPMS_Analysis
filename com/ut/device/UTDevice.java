package com.ut.device;

import android.content.Context;

public class UTDevice {
  @Deprecated
  public static String getAid(String paramString1, String paramString2, Context paramContext) {
    return "";
  }
  
  @Deprecated
  public static void getAidAsync(String paramString1, String paramString2, Context paramContext, AidCallback paramAidCallback) {}
  
  public static String getUtdid(Context paramContext) {
    return com.ta.utdid2.device.UTDevice.getUtdid(paramContext);
  }
  
  @Deprecated
  public static String getUtdidForUpdate(Context paramContext) {
    return com.ta.utdid2.device.UTDevice.getUtdidForUpdate(paramContext);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\ut\device\UTDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */