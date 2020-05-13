package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;

public final class x {
  public static String a = "CrashReport";
  
  public static boolean b = false;
  
  private static String c = "CrashReportInfo";
  
  private static boolean a(int paramInt, String paramString, Object... paramVarArgs) {
    String str;
    if (!b)
      return false; 
    if (paramString == null) {
      str = "null";
    } else {
      str = paramString;
      if (paramVarArgs != null)
        if (paramVarArgs.length == 0) {
          str = paramString;
        } else {
          str = String.format(Locale.US, paramString, paramVarArgs);
        }  
    } 
    if (paramInt != 5) {
      switch (paramInt) {
        default:
          return false;
        case 3:
          Log.e(a, str);
          return true;
        case 2:
          Log.w(a, str);
          return true;
        case 1:
          Log.d(a, str);
          return true;
        case 0:
          break;
      } 
      Log.i(a, str);
      return true;
    } 
    Log.i(c, str);
    return true;
  }
  
  public static boolean a(Class paramClass, String paramString, Object... paramVarArgs) {
    return a(0, String.format(Locale.US, "[%s] %s", new Object[] { paramClass.getSimpleName(), paramString }), paramVarArgs);
  }
  
  public static boolean a(String paramString, Object... paramVarArgs) {
    return a(0, paramString, paramVarArgs);
  }
  
  public static boolean a(Throwable paramThrowable) {
    return !b ? false : a(2, z.a(paramThrowable), new Object[0]);
  }
  
  public static boolean b(Class paramClass, String paramString, Object... paramVarArgs) {
    return a(1, String.format(Locale.US, "[%s] %s", new Object[] { paramClass.getSimpleName(), paramString }), paramVarArgs);
  }
  
  public static boolean b(String paramString, Object... paramVarArgs) {
    return a(5, paramString, paramVarArgs);
  }
  
  public static boolean b(Throwable paramThrowable) {
    return !b ? false : a(3, z.a(paramThrowable), new Object[0]);
  }
  
  public static boolean c(String paramString, Object... paramVarArgs) {
    return a(1, paramString, paramVarArgs);
  }
  
  public static boolean d(String paramString, Object... paramVarArgs) {
    return a(2, paramString, paramVarArgs);
  }
  
  public static boolean e(String paramString, Object... paramVarArgs) {
    return a(3, paramString, paramVarArgs);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\proguard\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */