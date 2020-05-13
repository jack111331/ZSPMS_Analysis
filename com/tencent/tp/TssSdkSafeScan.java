package com.tencent.tp;

import android.content.Context;
import android.os.AsyncTask;

public class TssSdkSafeScan {
  private static void scan(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    (new ad(paramContext, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
  }
  
  public static void scan(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    Context context = TssSdkRuntime.getAppContext();
    if (context != null)
      scan(context, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\TssSdkSafeScan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */