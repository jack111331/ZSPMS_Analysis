package com.sdk.base.framework.utils.i;

import android.content.Context;
import com.sdk.base.framework.utils.a.a;

public class b {
  private static boolean a = false;
  
  public static boolean a(Context paramContext) {
    boolean bool = true;
    if (!a) {
      Long long_ = a.c(paramContext, "access_limit_time");
      long l = System.currentTimeMillis();
      if (long_ == null) {
        a.a(paramContext, "access_limit_time", Long.valueOf(l));
        return bool;
      } 
      if (l - long_.longValue() > 600000L) {
        a.a(paramContext, "access_limit_time", Long.valueOf(l));
        a.a(paramContext, "access_limit_count", Long.valueOf(0L));
        return bool;
      } 
      long_ = a.c(paramContext, "access_limit_count");
      if (long_ == null) {
        a.a(paramContext, "access_limit_count", Long.valueOf(0L));
        return bool;
      } 
      if (long_.longValue() > 30L)
        bool = false; 
    } 
    return bool;
  }
  
  public static void b(Context paramContext) {
    Long long_ = a.c(paramContext, "access_limit_count");
    if (long_ == null) {
      a.a(paramContext, "access_limit_count", Long.valueOf(0L));
      return;
    } 
    a.a(paramContext, "access_limit_count", Long.valueOf(long_.longValue() + 1L));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */