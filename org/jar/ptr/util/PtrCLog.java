package org.jar.ptr.util;

import android.util.Log;

public class PtrCLog {
  public static final int LEVEL_DEBUG = 1;
  
  public static final int LEVEL_ERROR = 4;
  
  public static final int LEVEL_FATAL = 5;
  
  public static final int LEVEL_INFO = 2;
  
  public static final int LEVEL_VERBOSE = 0;
  
  public static final int LEVEL_WARNING = 3;
  
  private static int sLevel;
  
  public static void d(String paramString1, String paramString2) {
    if (sLevel > 1)
      return; 
    Log.d(paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable) {
    if (sLevel > 1)
      return; 
    Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs) {
    if (sLevel > 1)
      return; 
    String str = paramString2;
    if (paramVarArgs.length > 0)
      str = String.format(paramString2, paramVarArgs); 
    Log.d(paramString1, str);
  }
  
  public static void e(String paramString1, String paramString2) {
    if (sLevel > 4)
      return; 
    Log.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable) {
    if (sLevel > 4)
      return; 
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs) {
    if (sLevel > 4)
      return; 
    String str = paramString2;
    if (paramVarArgs.length > 0)
      str = String.format(paramString2, paramVarArgs); 
    Log.e(paramString1, str);
  }
  
  public static void f(String paramString1, String paramString2) {
    if (sLevel > 5)
      return; 
    Log.wtf(paramString1, paramString2);
  }
  
  public static void f(String paramString1, String paramString2, Throwable paramThrowable) {
    if (sLevel > 5)
      return; 
    Log.wtf(paramString1, paramString2, paramThrowable);
  }
  
  public static void f(String paramString1, String paramString2, Object... paramVarArgs) {
    if (sLevel > 5)
      return; 
    String str = paramString2;
    if (paramVarArgs.length > 0)
      str = String.format(paramString2, paramVarArgs); 
    Log.wtf(paramString1, str);
  }
  
  public static void i(String paramString1, String paramString2) {
    if (sLevel > 2)
      return; 
    Log.i(paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable) {
    if (sLevel > 2)
      return; 
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs) {
    if (sLevel > 2)
      return; 
    String str = paramString2;
    if (paramVarArgs.length > 0)
      str = String.format(paramString2, paramVarArgs); 
    Log.i(paramString1, str);
  }
  
  public static void setLogLevel(int paramInt) {
    sLevel = paramInt;
  }
  
  public static void v(String paramString1, String paramString2) {
    if (sLevel > 0)
      return; 
    Log.v(paramString1, paramString2);
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable) {
    if (sLevel > 0)
      return; 
    Log.v(paramString1, paramString2, paramThrowable);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs) {
    if (sLevel > 0)
      return; 
    String str = paramString2;
    if (paramVarArgs.length > 0)
      str = String.format(paramString2, paramVarArgs); 
    Log.v(paramString1, str);
  }
  
  public static void w(String paramString1, String paramString2) {
    if (sLevel > 3)
      return; 
    Log.w(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable) {
    if (sLevel > 3)
      return; 
    Log.w(paramString1, paramString2, paramThrowable);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs) {
    if (sLevel > 3)
      return; 
    String str = paramString2;
    if (paramVarArgs.length > 0)
      str = String.format(paramString2, paramVarArgs); 
    Log.w(paramString1, str);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\pt\\util\PtrCLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */