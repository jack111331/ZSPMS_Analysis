package com.qiniu.android.utils;

import android.os.Handler;
import android.os.Looper;

public final class AsyncRun {
  public static void runInBack(Runnable paramRunnable) {}
  
  public static void runInMain(Runnable paramRunnable) {
    (new Handler(Looper.getMainLooper())).post(paramRunnable);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\androi\\utils\AsyncRun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */