package com.zz.sdk.floatdlg.tabview;

import android.content.Context;
import android.util.TypedValue;

public class d {
  public static int a(Context paramContext, float paramFloat) {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  public static int b(Context paramContext, float paramFloat) {
    return (int)TypedValue.applyDimension(2, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\tabview\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */