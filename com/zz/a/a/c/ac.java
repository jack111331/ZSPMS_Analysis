package com.zz.a.a.c;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;

public class ac {
  static final boolean a = false;
  
  @TargetApi(11)
  public static void a(Class... paramVarArgs) {
    if (b()) {
      StrictMode.ThreadPolicy.Builder builder = (new StrictMode.ThreadPolicy.Builder()).detectAll().penaltyLog();
      StrictMode.VmPolicy.Builder builder1 = (new StrictMode.VmPolicy.Builder()).detectAll().penaltyLog();
      if (c()) {
        builder.penaltyFlashScreen();
        int i = paramVarArgs.length;
        for (byte b = 0; b < i; b++)
          builder1.setClassInstanceLimit(paramVarArgs[b], 1); 
      } 
      StrictMode.setThreadPolicy(builder.build());
      StrictMode.setVmPolicy(builder1.build());
    } 
  }
  
  public static boolean a() {
    return (Build.VERSION.SDK_INT >= 8);
  }
  
  public static boolean b() {
    return (Build.VERSION.SDK_INT >= 9);
  }
  
  public static boolean c() {
    return (Build.VERSION.SDK_INT >= 11);
  }
  
  public static boolean d() {
    return (Build.VERSION.SDK_INT >= 12);
  }
  
  public static boolean e() {
    return (Build.VERSION.SDK_INT >= 16);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */