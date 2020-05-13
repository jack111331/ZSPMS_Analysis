package com.alipay.sdk.util;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.encrypt.e;

public final class i {
  private static String a = null;
  
  private static String a(Context paramContext) {
    if (TextUtils.isEmpty(a)) {
      String str1;
      String str2 = "";
      try {
        str1 = paramContext.getApplicationContext().getPackageName();
      } catch (Throwable throwable) {
        str1 = str2;
      } 
      a = (str1 + "0000000000000000000000000000").substring(0, 24);
    } 
    return a;
  }
  
  public static void a(Context paramContext, String paramString) {
    try {
      PreferenceManager.getDefaultSharedPreferences(paramContext).edit().remove(paramString).commit();
    } catch (Throwable throwable) {}
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    try {
      String str = e.a(a(paramContext), paramString2);
      if (!TextUtils.isEmpty(paramString2) && TextUtils.isEmpty(str))
        a.a("cp", "TriDesDecryptError", String.format("%s,%s", new Object[] { paramString1, paramString2 })); 
      PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString(paramString1, str).commit();
    } catch (Throwable throwable) {}
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2) {
    String str1;
    String str2 = null;
    String str3 = null;
    String str4 = str2;
    try {
      String str = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString1, paramString2);
      paramString2 = str3;
      str4 = str2;
      if (!TextUtils.isEmpty(str)) {
        str4 = str2;
        paramString2 = e.b(a(paramContext), str);
      } 
      str1 = paramString2;
      str4 = paramString2;
      if (!TextUtils.isEmpty(str)) {
        str1 = paramString2;
        str4 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          str4 = paramString2;
          a.a("cp", "TriDesEncryptError", String.format("%s,%s", new Object[] { paramString1, str }));
          str1 = paramString2;
        } 
      } 
    } catch (Exception exception) {
      str1 = str4;
    } 
    return str1;
  }
  
  private static boolean b(Context paramContext, String paramString) {
    boolean bool2;
    boolean bool1 = false;
    try {
      bool2 = PreferenceManager.getDefaultSharedPreferences(paramContext).contains(paramString);
    } catch (Throwable throwable) {
      bool2 = bool1;
    } 
    return bool2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sd\\util\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */