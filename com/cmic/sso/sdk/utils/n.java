package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

public class n {
  private static boolean a = v.a();
  
  private static String b;
  
  private static String c;
  
  public static String a(Context paramContext) {
    if (!a) {
      String str = r.b(paramContext, "phonescripcache", "");
      if (TextUtils.isEmpty(str)) {
        h.a("PhoneScripUtils", "null");
        return "";
      } 
      return g.b(paramContext, str);
    } 
    return b;
  }
  
  public static void a(Context paramContext, String paramString1, long paramLong, String paramString2) {
    if (!a) {
      h.b("PhoneScripUtils", paramString1 + " " + paramLong + " " + paramString2);
      r.a(paramContext, "phonescripcache", g.a(paramContext, paramString1));
      r.a(paramContext, "phonescripstarttime", paramLong);
      r.a(paramContext, "preimsi", paramString2);
      return;
    } 
    b = paramString1;
    c = paramString2;
  }
  
  public static void a(Context paramContext, boolean paramBoolean) {
    r.a(paramContext, "phonescripstarttime");
    r.a(paramContext, "phonescripcache");
    r.a(paramContext, "preimsi");
    if (paramBoolean) {
      b = null;
      c = null;
    } 
  }
  
  public static boolean a(Context paramContext, Bundle paramBundle) {
    boolean bool1 = true;
    boolean bool2 = false;
    int i = b(paramContext);
    paramBundle.putString("imsiState", i + "");
    if (i == 1) {
      if (a) {
        h.b("PhoneScripUtils", "phone is root");
        a(paramContext, false);
        return !TextUtils.isEmpty(b) ? bool1 : false;
      } 
      bool2 = c(paramContext);
    } 
    return bool2;
  }
  
  public static int b(Context paramContext) {
    String str2;
    if (a) {
      str2 = c;
    } else {
      str2 = r.b(paramContext, "preimsi", "");
    } 
    if (TextUtils.isEmpty(str2))
      return 0; 
    String str1 = q.a(paramContext).a();
    return str2.equals(str1) ? 1 : ((str1.length() == 16) ? 3 : 2);
  }
  
  private static boolean c(Context paramContext) {
    boolean bool = true;
    if (!a) {
      if (TextUtils.isEmpty(r.b(paramContext, "phonescripcache", "")) || d(paramContext))
        bool = false; 
      return bool;
    } 
    if (TextUtils.isEmpty(b))
      bool = false; 
    return bool;
  }
  
  private static boolean d(Context paramContext) {
    long l1 = r.b(paramContext, "phonescripstarttime", 0L);
    long l2 = System.currentTimeMillis();
    h.b("PhoneScripUtils", l1 + "");
    h.b("PhoneScripUtils", l2 + "");
    return (l1 - l2 <= 120000L);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */