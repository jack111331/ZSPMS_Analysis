package com.tencent.tp;

import android.os.Handler;
import android.os.Looper;

public class MainThreadDispatcher2 {
  public static void SendCmd(String paramString) {
    if (paramString.startsWith("sub:")) {
      doOnCmd(paramString.substring(4));
      return;
    } 
    if (paramString.startsWith("update_adb_enabled_over_usb:")) {
      doOnCmd(paramString);
      return;
    } 
    (new Handler(Looper.getMainLooper())).post(onCmdRunnable(paramString));
  }
  
  private static void doOnCmd(String paramString) {
    TssJavaMethod.sendCmd(paramString);
  }
  
  private static Runnable onCmdRunnable(String paramString) {
    return new a(paramString);
  }
  
  static class a implements Runnable {
    private String a;
    
    public a(String param1String) {
      this.a = param1String;
    }
    
    public void run() {
      MainThreadDispatcher2.doOnCmd(this.a);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\MainThreadDispatcher2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */