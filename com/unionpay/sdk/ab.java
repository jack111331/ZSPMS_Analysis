package com.unionpay.sdk;

import android.content.Context;
import android.os.Handler;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.TreeMap;

public class ab {
  static final Map a = new TreeMap<Object, Object>();
  
  static boolean b = false;
  
  static Handler c;
  
  static FileChannel d;
  
  static long e;
  
  static boolean f;
  
  static boolean g;
  
  static boolean h;
  
  static String i;
  
  static String j;
  
  static long k;
  
  static long l;
  
  public static Context mContext = null;
  
  static {
    c = null;
    e = 0L;
    f = false;
    g = true;
    h = true;
    i = "";
    j = "Default";
    l = 30000L;
  }
  
  static String a(Context paramContext) {
    if (k.b(i) && paramContext != null)
      i = h.b(paramContext, "UP_app_pefercen_profile", "UP_appId", ""); 
    return i;
  }
  
  static void a(String paramString1, String paramString2) {
    if (mContext != null)
      c = new Handler(mContext.getMainLooper()); 
    if (paramString1 != null && !paramString1.trim().isEmpty() && paramString1.contains("-")) {
      Throwable throwable1 = null;
      try {
        paramString1 = paramString1.split("-")[1];
      } catch (Throwable throwable) {
        throwable = throwable1;
      } 
      i = (String)throwable;
    } else {
      i = (String)throwable;
    } 
    if (paramString2 != null && !paramString2.trim().isEmpty())
      j = paramString2; 
    k.execute(new ag());
  }
  
  public static String getAdTrackingAppId() {
    return h.b(mContext, "UP_app_pefercen_profile", "UP_tracking_appId", (String)null);
  }
  
  public static String getAppAnalyticsAppId() {
    return h.b(mContext, "UP_app_pefercen_profile", "UP_analytics_appId", (String)null);
  }
  
  public static String getChannelId() {
    return h.b(mContext, "UP_app_pefercen_profile", "UP_channelId", (String)null);
  }
  
  public static String getGameAnalyticsAppId() {
    return h.b(mContext, "UP_app_pefercen_profile", "UP_game_appId", (String)null);
  }
  
  public static String getPartnerId(Context paramContext) {
    if (k.b(j) || j.equals("Default"))
      j = h.b(paramContext, "UP_app_pefercen_profile", "UP_channelId", ""); 
    return j;
  }
  
  public static void setAdTrackingAppId(String paramString) {
    h.a(mContext, "UP_app_pefercen_profile", "UP_tracking_appId", paramString);
  }
  
  public static void setAppAnalyticsAppId(String paramString) {
    h.a(mContext, "UP_app_pefercen_profile", "UP_analytics_appId", paramString);
  }
  
  public static void setChannelId(String paramString) {
    h.a(mContext, "UP_app_pefercen_profile", "UP_channelId", paramString);
  }
  
  public static void setGameAnalyticsAppId(String paramString) {
    h.a(mContext, "UP_app_pefercen_profile", "UP_game_appId", paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */