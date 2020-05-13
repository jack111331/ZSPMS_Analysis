package com.chuanglan.shanyan_sdk.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class AbScreenUtils {
  private static Handler a;
  
  private AbScreenUtils() {
    throw new UnsupportedOperationException("cannot be instantiated");
  }
  
  private static void a(Runnable paramRunnable) {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      paramRunnable.run();
      return;
    } 
    a.post(paramRunnable);
  }
  
  public static int dp2px(Context paramContext, float paramFloat) {
    return (int)((paramContext.getResources().getDisplayMetrics()).density * paramFloat + 0.5F);
  }
  
  public static void showToast(Context paramContext, String paramString) {
    a = new Handler(Looper.getMainLooper());
    a(new Runnable(paramContext, paramString) {
          public void run() {
            Toast.makeText(this.a, this.b, 0).show();
          }
        });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sd\\utils\AbScreenUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */