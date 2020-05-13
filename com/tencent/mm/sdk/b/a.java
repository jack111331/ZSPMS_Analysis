package com.tencent.mm.sdk.b;

import android.os.Build;
import android.os.Looper;
import android.os.Process;

public final class a {
  private static int level = 6;
  
  public static d q;
  
  private static a r;
  
  private static a s;
  
  private static final String t;
  
  static {
    b b = new b();
    r = b;
    s = b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
    stringBuilder.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
    stringBuilder.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
    stringBuilder.append("] BOARD:[" + Build.BOARD);
    stringBuilder.append("] DEVICE:[" + Build.DEVICE);
    stringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
    stringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
    stringBuilder.append("] HOST:[" + Build.HOST);
    stringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
    stringBuilder.append("] MODEL:[" + Build.MODEL);
    stringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
    stringBuilder.append("] TAGS:[" + Build.TAGS);
    stringBuilder.append("] TYPE:[" + Build.TYPE);
    stringBuilder.append("] USER:[" + Build.USER + "]");
    t = stringBuilder.toString();
  }
  
  public static void a(String paramString1, String paramString2) {
    a(paramString1, paramString2, null);
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs) {
    if (s != null && s.h() <= 4) {
      if (paramVarArgs != null)
        paramString2 = String.format(paramString2, paramVarArgs); 
      String str = paramString2;
      if (paramString2 == null)
        str = ""; 
      paramString1 = i(paramString1);
      a a1 = s;
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      a1.h(paramString1, str);
    } 
  }
  
  public static void b(String paramString1, String paramString2) {
    if (s != null && s.h() <= 3) {
      String str = paramString2;
      if (paramString2 == null)
        str = ""; 
      paramString2 = i(paramString1);
      a a1 = s;
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      a1.g(paramString2, str);
    } 
  }
  
  public static void c(String paramString1, String paramString2) {
    if (s != null && s.h() <= 2) {
      String str = paramString2;
      if (paramString2 == null)
        str = ""; 
      paramString1 = i(paramString1);
      a a1 = s;
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      a1.e(paramString1, str);
    } 
  }
  
  public static void d(String paramString1, String paramString2) {
    if (s != null && s.h() <= 1) {
      String str = paramString2;
      if (paramString2 == null)
        str = ""; 
      paramString2 = i(paramString1);
      a a1 = s;
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      a1.f(paramString2, str);
    } 
  }
  
  private static String i(String paramString) {
    String str = paramString;
    if (q != null)
      str = q.i(paramString); 
    return str;
  }
  
  public static interface a {
    void e(String param1String1, String param1String2);
    
    void f(String param1String1, String param1String2);
    
    void g(String param1String1, String param1String2);
    
    int h();
    
    void h(String param1String1, String param1String2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */