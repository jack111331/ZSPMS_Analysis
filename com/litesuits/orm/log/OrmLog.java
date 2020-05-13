package com.litesuits.orm.log;

import android.util.Log;

public final class OrmLog {
  private static String defaultTag = "OrmLog";
  
  public static boolean isPrint;
  
  public static int d(Object paramObject, String paramString) {
    byte b;
    if (isPrint) {
      b = Log.d(paramObject.getClass().getSimpleName(), paramString);
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int d(String paramString1, String paramString2) {
    byte b;
    if (isPrint && paramString2 != null) {
      b = Log.d(paramString1, paramString2);
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int d(String paramString1, String paramString2, Throwable paramThrowable) {
    byte b;
    if (isPrint && paramString2 != null) {
      b = Log.d(paramString1, paramString2, paramThrowable);
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int d(String paramString, Object... paramVarArgs) {
    byte b;
    if (isPrint) {
      b = Log.d(paramString, getLogMessage(paramVarArgs));
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int e(Object paramObject, String paramString) {
    byte b;
    if (isPrint) {
      b = Log.e(paramObject.getClass().getSimpleName(), paramString);
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int e(String paramString1, String paramString2) {
    byte b;
    if (isPrint && paramString2 != null) {
      b = Log.e(paramString1, paramString2);
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int e(String paramString1, String paramString2, Throwable paramThrowable) {
    byte b;
    if (isPrint && paramString2 != null) {
      b = Log.e(paramString1, paramString2, paramThrowable);
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int e(String paramString, Object... paramVarArgs) {
    byte b;
    if (isPrint) {
      b = Log.e(paramString, getLogMessage(paramVarArgs));
    } else {
      b = -1;
    } 
    return b;
  }
  
  private static String getLogMessage(Object... paramVarArgs) {
    if (paramVarArgs != null && paramVarArgs.length > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      int i = paramVarArgs.length;
      for (byte b = 0; b < i; b++) {
        Object object = paramVarArgs[b];
        if (object != null)
          stringBuilder.append(object.toString()); 
      } 
      return stringBuilder.toString();
    } 
    return "";
  }
  
  public static int i(Object paramObject) {
    byte b;
    if (isPrint && paramObject != null) {
      b = Log.i(defaultTag, paramObject.toString());
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int i(Object paramObject, String paramString) {
    byte b;
    if (isPrint) {
      b = Log.i(paramObject.getClass().getSimpleName(), paramString);
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int i(String paramString) {
    byte b;
    if (isPrint && paramString != null) {
      b = Log.i(defaultTag, paramString);
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int i(String paramString1, String paramString2) {
    byte b;
    if (isPrint && paramString2 != null) {
      b = Log.i(paramString1, paramString2);
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int i(String paramString1, String paramString2, Throwable paramThrowable) {
    byte b;
    if (isPrint && paramString2 != null) {
      b = Log.i(paramString1, paramString2, paramThrowable);
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int i(String paramString, Object... paramVarArgs) {
    byte b;
    if (isPrint) {
      b = Log.i(paramString, getLogMessage(paramVarArgs));
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static void setTag(String paramString) {
    defaultTag = paramString;
  }
  
  public static int v(Object paramObject, String paramString) {
    byte b;
    if (isPrint) {
      b = Log.v(paramObject.getClass().getSimpleName(), paramString);
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int v(String paramString1, String paramString2) {
    byte b;
    if (isPrint && paramString2 != null) {
      b = Log.v(paramString1, paramString2);
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int v(String paramString1, String paramString2, Throwable paramThrowable) {
    byte b;
    if (isPrint && paramString2 != null) {
      b = Log.v(paramString1, paramString2, paramThrowable);
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int v(String paramString, Object... paramVarArgs) {
    byte b;
    if (isPrint) {
      b = Log.v(paramString, getLogMessage(paramVarArgs));
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int w(Object paramObject, String paramString) {
    byte b;
    if (isPrint) {
      b = Log.w(paramObject.getClass().getSimpleName(), paramString);
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int w(String paramString1, String paramString2) {
    byte b;
    if (isPrint && paramString2 != null) {
      b = Log.w(paramString1, paramString2);
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int w(String paramString1, String paramString2, Throwable paramThrowable) {
    byte b;
    if (isPrint && paramString2 != null) {
      b = Log.w(paramString1, paramString2, paramThrowable);
    } else {
      b = -1;
    } 
    return b;
  }
  
  public static int w(String paramString, Object... paramVarArgs) {
    byte b;
    if (isPrint) {
      b = Log.w(paramString, getLogMessage(paramVarArgs));
    } else {
      b = -1;
    } 
    return b;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\log\OrmLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */