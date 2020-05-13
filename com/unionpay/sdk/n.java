package com.unionpay.sdk;

import android.content.Context;
import android.os.HandlerThread;

public class n {
  public static Context a;
  
  public static String b = null;
  
  public static String c = null;
  
  public static final String d = "app";
  
  static HandlerThread e;
  
  static {
    HandlerThread handlerThread = new HandlerThread("TalkingDataMain");
    e = handlerThread;
    handlerThread.start();
  }
  
  public static String a(Context paramContext) {
    return d.a(paramContext);
  }
  
  public static void a(Context paramContext, String paramString) {
    b = paramString;
    init(paramContext);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    c = paramString2;
    a(paramContext, paramString1);
  }
  
  public static String b(Context paramContext) {
    return ab.getPartnerId(paramContext);
  }
  
  public static void init(Context paramContext) {
    try {
      String str = ab.getAppAnalyticsAppId();
      if (!k.b(str))
        UPAgent.init(paramContext, str, ab.getChannelId()); 
    } catch (Throwable throwable) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */