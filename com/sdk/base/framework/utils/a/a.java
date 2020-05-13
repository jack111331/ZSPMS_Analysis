package com.sdk.base.framework.utils.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.f.b;
import com.sdk.base.framework.utils.i.c;
import java.nio.charset.Charset;

public class a {
  private static final String a = a.class.getName();
  
  private static final Boolean b = Boolean.valueOf(c.h);
  
  public static String a(Context paramContext, String paramString) {
    String str = "";
    try {
      paramString = paramContext.getSharedPreferences("ZzxCache", 0).getString(paramString, "");
      str = paramString;
      String str1 = new String();
      str = paramString;
      this(c.a(paramString), Charset.defaultCharset());
      str = str1;
    } catch (Exception exception) {
      b.c(a, exception.getMessage(), b);
    } 
    return str;
  }
  
  public static void a(Context paramContext, String paramString, Long paramLong) {
    try {
      SharedPreferences.Editor editor = paramContext.getSharedPreferences("ZzxCache", 0).edit();
      editor.putLong(paramString, paramLong.longValue());
      editor.commit();
    } catch (Exception exception) {
      b.c(a, exception.getMessage(), b);
    } 
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2) {
    boolean bool2;
    boolean bool1 = false;
    try {
      SharedPreferences.Editor editor = paramContext.getSharedPreferences("ZzxCache", 0).edit();
      editor.putString(paramString1, c.a(paramString2.getBytes(Charset.defaultCharset())));
      bool2 = editor.commit();
    } catch (Exception exception) {
      b.c(a, exception.getMessage(), b);
      bool2 = bool1;
    } 
    return bool2;
  }
  
  public static String b(Context paramContext, String paramString) {
    String str1;
    String str2 = "";
    try {
      str1 = paramContext.getSharedPreferences("ZzxCache", 0).getString(paramString, "");
    } catch (Exception exception) {
      b.c(a, exception.getMessage(), b);
      str1 = str2;
    } 
    return str1;
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2) {
    boolean bool = false;
    try {
      SharedPreferences.Editor editor = paramContext.getSharedPreferences("ZzxCache", 0).edit();
      editor.putString(paramString1, paramString2);
      boolean bool1 = editor.commit();
      bool = bool1;
    } catch (Exception exception) {
      b.c(a, exception.getMessage(), b);
    } 
    return bool;
  }
  
  public static Long c(Context paramContext, String paramString) {
    Long long_1;
    Long long_2 = Long.valueOf(0L);
    try {
      long l = paramContext.getSharedPreferences("ZzxCache", 0).getLong(paramString, 0L);
      long_1 = Long.valueOf(l);
    } catch (Exception exception) {
      b.c(a, exception.getMessage(), b);
      long_1 = long_2;
    } 
    return long_1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */