package com.tencent.connect.a;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.e;
import java.lang.reflect.Method;

public class a {
  private static Class<?> a = null;
  
  private static Class<?> b = null;
  
  private static Method c = null;
  
  private static Method d = null;
  
  private static Method e = null;
  
  private static Method f = null;
  
  private static boolean g = false;
  
  public static void a(Context paramContext, QQToken paramQQToken, String paramString, String... paramVarArgs) {
    if (g) {
      b(paramContext, paramQQToken);
      try {
        d.invoke(b, new Object[] { paramContext, paramString, paramVarArgs });
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
  }
  
  public static boolean a(Context paramContext, QQToken paramQQToken) {
    return e.a(paramContext, paramQQToken.getAppId()).b("Common_ta_enable");
  }
  
  public static void b(Context paramContext, QQToken paramQQToken) {
    try {
      if (a(paramContext, paramQQToken)) {
        f.invoke(a, new Object[] { Boolean.valueOf(true) });
        return;
      } 
      f.invoke(a, new Object[] { Boolean.valueOf(false) });
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void c(Context paramContext, QQToken paramQQToken) {
    String str = paramQQToken.getAppId();
    str = "Aqc" + str;
    try {
      a = Class.forName("com.tencent.stat.StatConfig");
      b = Class.forName("com.tencent.stat.StatService");
      c = b.getMethod("reportQQ", new Class[] { Context.class, String.class });
      d = b.getMethod("trackCustomEvent", new Class[] { Context.class, String.class, String[].class });
      e = b.getMethod("commitEvents", new Class[] { Context.class, int.class });
      f = a.getMethod("setEnableStatService", new Class[] { boolean.class });
      b(paramContext, paramQQToken);
      a.getMethod("setAutoExceptionCaught", new Class[] { boolean.class }).invoke(a, new Object[] { Boolean.valueOf(false) });
      a.getMethod("setEnableSmartReporting", new Class[] { boolean.class }).invoke(a, new Object[] { Boolean.valueOf(true) });
      a.getMethod("setSendPeriodMinutes", new Class[] { int.class }).invoke(a, new Object[] { Integer.valueOf(1440) });
      Class<?> clazz = Class.forName("com.tencent.stat.StatReportStrategy");
      a.getMethod("setStatSendStrategy", new Class[] { clazz }).invoke(a, new Object[] { clazz.getField("PERIOD").get(null) });
      b.getMethod("startStatService", new Class[] { Context.class, String.class, String.class }).invoke(b, new Object[] { paramContext, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null) });
      g = true;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void d(Context paramContext, QQToken paramQQToken) {
    if (g) {
      b(paramContext, paramQQToken);
      if (paramQQToken.getOpenId() != null)
        try {
          c.invoke(b, new Object[] { paramContext, paramQQToken.getOpenId() });
        } catch (Exception exception) {
          exception.printStackTrace();
        }  
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\connect\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */