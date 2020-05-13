package com.cmic.sso.sdk.utils;

import com.cmic.sso.sdk.auth.TokenListener;
import java.util.concurrent.ConcurrentHashMap;

public class k {
  private static ConcurrentHashMap<String, TokenListener> a = new ConcurrentHashMap<String, TokenListener>();
  
  private static ConcurrentHashMap<String, Boolean> b = new ConcurrentHashMap<String, Boolean>();
  
  public static void a(String paramString, TokenListener paramTokenListener) {
    a.put(paramString, paramTokenListener);
  }
  
  public static boolean a() {
    return a.isEmpty();
  }
  
  public static boolean a(String paramString) {
    return !a.containsKey(paramString);
  }
  
  public static boolean b(String paramString) {
    return b.containsKey(paramString);
  }
  
  public static void c(String paramString) {
    b.put(paramString, Boolean.valueOf(true));
  }
  
  public static void d(String paramString) {
    a.remove(paramString);
    if (b.containsKey(paramString))
      b.remove(paramString); 
  }
  
  public static TokenListener e(String paramString) {
    return a.get(paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */