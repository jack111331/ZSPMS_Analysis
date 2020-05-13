package com.zz.sdk.i;

import android.content.Context;

public class bz {
  private static float a = 1.0F;
  
  public static int a(int paramInt) {
    return (int)(paramInt * a + 0.5F);
  }
  
  public static void a() {}
  
  public static void a(Context paramContext) {
    a = (paramContext.getResources().getDisplayMetrics()).density;
  }
  
  public static int b(int paramInt) {
    return (int)(paramInt / a + 0.5F);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */