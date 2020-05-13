package com.xy.whf.helper;

import android.content.Context;
import android.util.DisplayMetrics;

public class e {
  public static int a(Context paramContext, int paramInt) {
    return (int)((b(paramContext) * paramInt) + 0.5D);
  }
  
  public static DisplayMetrics a(Context paramContext) {
    return paramContext.getResources().getDisplayMetrics();
  }
  
  public static float b(Context paramContext) {
    return (a(paramContext)).density;
  }
  
  public static String c(Context paramContext) {
    return (paramContext.getResources().getDisplayMetrics()).widthPixels + "*" + (paramContext.getResources().getDisplayMetrics()).heightPixels;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\helper\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */