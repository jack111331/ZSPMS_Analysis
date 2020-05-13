package com.sdk.base.module.manager;

import android.content.Context;
import android.support.annotation.Keep;
import com.sdk.base.api.CallBack;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.app.AppUtils;
import com.sdk.base.module.a.a;

public abstract class SDKManager {
  protected static Context a;
  
  private static String b = "";
  
  private static boolean c = true;
  
  public static String a() {
    return b;
  }
  
  protected static <T> void a(CallBack<T> paramCallBack, int paramInt, String paramString) {
    if (paramCallBack != null)
      paramCallBack.onFailed(1, paramInt, paramString); 
  }
  
  public static <T> void a(String paramString) {
    b = paramString;
  }
  
  public static void a(boolean paramBoolean) {
    c.i = paramBoolean;
  }
  
  public static Context b() {
    return a;
  }
  
  public static void b(boolean paramBoolean) {
    c = paramBoolean;
  }
  
  public static boolean c() {
    return c;
  }
  
  @Keep
  public static void init(Context paramContext, String paramString) {
    a = paramContext;
    a.a(paramContext).a(Boolean.valueOf(AppUtils.isFirstLogin(paramContext)), null, paramString);
  }
  
  @Keep
  public static void init(Context paramContext, String paramString1, String paramString2) {
    a = paramContext;
    a.a(paramContext).a(Boolean.valueOf(AppUtils.isFirstLogin(paramContext)), paramString1, paramString2);
  }
  
  @Keep
  public static void setDebug(boolean paramBoolean) {
    c.h = paramBoolean;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\module\manager\SDKManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */