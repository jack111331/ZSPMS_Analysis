package com.chuanglan.shanyan_sdk.utils;

import android.content.Context;

public class MultiClickUtilstwo {
  private static long a;
  
  public static boolean isFastClick(Context paramContext) {
    Long long_ = (Long)SPTool.get(paramContext, "authPageFlag", Long.valueOf(2L));
    long l = System.currentTimeMillis();
    if (l - a >= long_.longValue() * 1000L || l - a < 0L) {
      boolean bool = true;
      a = l;
      return bool;
    } 
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sd\\utils\MultiClickUtilstwo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */